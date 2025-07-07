package com.likelion.febebug.domain.comment.mapper;

import com.likelion.febebug.domain.comment.dto.response.CommentResponse;
import com.likelion.febebug.domain.comment.entity.Comment;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

  public CommentResponse toCommentResponse(Comment comment) {

    return CommentResponse.builder()
        .id(comment.getId())
        .postId(comment.getPost().getId())
        .content(comment.getContent())
        .writer(comment.getWriter())
        .build();
  }

  public List<CommentResponse> toCommentResponseList(List<Comment> commentList) {

    return commentList.stream()
        .map(this::toCommentResponse)
        .toList();
  }
}
