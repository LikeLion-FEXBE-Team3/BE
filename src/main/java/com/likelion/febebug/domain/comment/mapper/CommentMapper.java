package com.likelion.febebug.domain.comment.mapper;

import com.likelion.febebug.domain.comment.dto.response.CommentResponse;
import com.likelion.febebug.domain.comment.entity.Comment;
import java.util.List;

public class CommentMapper {

  public CommentResponse toCommentResponse(Comment comment) {

    return CommentResponse.builder()
        .id(comment.getId())
        .postId(comment.getPost().getId())
        .content(comment.getContent())
        .writer(comment.getWriter())
        .build();
  }

  public List<CommentResponse> toCommnetResponseList(List<Comment> commnetList) {

    return commnetList.stream()
        .map(this::toCommentResponse)
        .toList();
  }
}
