package com.likelion.febebug.domain.comment.service;

import com.likelion.febebug.domain.comment.dto.request.CommentRequest;
import com.likelion.febebug.domain.comment.dto.response.CommentResponse;
import com.likelion.febebug.domain.comment.entity.Comment;
import com.likelion.febebug.domain.comment.exception.CommentErrorCode;
import com.likelion.febebug.domain.comment.mapper.CommentMapper;
import com.likelion.febebug.domain.comment.repository.CommentRepository;
import com.likelion.febebug.domain.post.entity.Post;
import com.likelion.febebug.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

  private final CommentRepository commentRepository;
  private final CommentMapper commentMapper;
  private final PostRepository postRepository;

  @Transactional
  public CommentResponse createComment(Long postId, CommentRequest commentRequest) {

    log.info("[서비스] 댓글 생성 시도: title={}, content={}",
        commentRequest.getContent(), commentRequest.getWriter());

    if (commentRequest.getContent() == null || commentRequest.getContent().isBlank()) {
      throw new CustomException(CommentErrorCode.INVALID_COMMENT_CONTENT);
    }

    Post post = postRepository.findById(postId)
        .orElseThrow(() -> new CustomException(PostErrorCode.POST_NOT_FOUND));

    Comment comment = Comment.builder()
        .post(post)
        .content(commentRequest.getContent())
        .writer(commentRequest.getWriter())
        .build();
    commentRepository.save(comment);

    return commentMapper.toCommentResponse(comment);
  }
}
