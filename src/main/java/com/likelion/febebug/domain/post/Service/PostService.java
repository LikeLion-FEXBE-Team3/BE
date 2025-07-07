package com.likelion.febebug.domain.post.Service;

import com.likelion.febebug.domain.post.dto.request.CreatePostRequest;
import com.likelion.febebug.domain.post.dto.response.PostResponse;
import com.likelion.febebug.domain.post.entity.Post;
import com.likelion.febebug.domain.post.exception.PostErrorCode;
import com.likelion.febebug.domain.post.mapper.PostMapper;
import com.likelion.febebug.domain.post.repository.PostRepository;
import com.likelion.febebug.global.exception.CustomException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {
  private final PostRepository postRepository;
  private final PostMapper postMapper;

  // 게시글 생성
  @Transactional
  public PostResponse createPost(CreatePostRequest request) {
    Post saved = postRepository.save(Post.builder()
        .title(request.getTitle())
        .description(request.getDescription())
        .genre(request.getGenre())
        .writer(request.getWriter())
        .imageUrl(request.getImageUrl())
        .build());
    log.info("[서비스] 게시글 생성: id={}", saved.getId());
    return postMapper.toPostResponse(saved);
  }

  // 게시글 전체 조회
  public List<PostResponse> getAllPosts() {
    log.info("[서비스] 게시글 전체 조회");
    return postRepository.findAll()
        .stream()
        .map(postMapper::toPostResponse)
        .toList();
  }

  // 게시글 단일 조회 및 조회수 증가
  @Transactional
  public PostResponse getPostById(Long id) {
    Post post = postRepository.findById(id)
        .orElseThrow(() -> new CustomException(PostErrorCode.POST_NOT_FOUND));
    post.increaseViews();
    log.info("[서비스] 게시글 조회: id={}", id);



    return postMapper.toPostResponse(post);
  }

  // 최신순
  public List<PostResponse> getPostsByNewest() {
    return postRepository.findAllByOrderByCreatedAtDesc()
        .stream()
        .map(postMapper::toPostResponse)
        .toList();
  }

  // 조회수순
  public List<PostResponse> getPostsByViews() {
    return postRepository.findAllByOrderByViewsDesc()
        .stream()
        .map(postMapper::toPostResponse)
        .toList();
  }
}
