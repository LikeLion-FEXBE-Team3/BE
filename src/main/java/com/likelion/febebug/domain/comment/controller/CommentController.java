package com.likelion.febebug.domain.comment.controller;

import com.likelion.febebug.domain.comment.dto.request.CommentRequest;
import com.likelion.febebug.domain.comment.dto.response.CommentResponse;
import com.likelion.febebug.domain.comment.entity.Comment;
import com.likelion.febebug.domain.comment.service.CommentService;
import com.likelion.febebug.global.Response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "Comment", description = "댓글 관련 API")
public class CommentController {

  private final CommentService commentService;

  @Operation(summary = "댓글 생성",
      description = "사용자가 댓글 작성을 했을 때 댓글이 생성되는 API")
  @PostMapping("/posts/{postId}")
  public ResponseEntity<BaseResponse<CommentResponse>> createComment(
      @Parameter(description = "특정 게시글 ID")
      @PathVariable Long postId,
      @Parameter(description = "게시글 작성 내용")
      @RequestBody @Valid CommentRequest commentRequest) {
    CommentResponse commentResponse = commentService.createComment(postId, commentRequest);

    return ResponseEntity.ok(BaseResponse.success("댓글 작성 성공", commentResponse));
  }
}






