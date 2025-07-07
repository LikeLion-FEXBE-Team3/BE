package com.likelion.febebug.domain.post.mapper;

import com.likelion.febebug.domain.comment.mapper.CommentMapper;
import com.likelion.febebug.domain.comment.service.CommentService;
import com.likelion.febebug.domain.post.dto.response.PostListResponse;
import com.likelion.febebug.domain.post.dto.response.PostResponse;
import com.likelion.febebug.domain.post.entity.Post;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

  private final CommentService commentService;

  public PostMapper(CommentService commentService) {
    this.commentService = commentService;
  }

  public PostResponse toPostResponse(Post post) {
    return PostResponse.builder()
        .id(post.getId())
        .title(post.getTitle())
        .description(post.getDescription())
        .genre(post.getGenre())
        .writer(post.getWriter())
        .imageUrl(post.getImageUrl())
        .createdAt(post.getCreatedAt())
        .views(post.getViews().longValue())
        .comments(commentService.getComments(post.getId()))
        .build();
  }

  public PostListResponse toListResponse(List<Post> posts) {
    return PostListResponse.builder()
        .posts(posts.stream().map(this::toPostResponse).toList())
        .build();
  }
}
