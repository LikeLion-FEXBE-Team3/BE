package com.likelion.febebug.domain.comment.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

public class CommentResponse {

  @Schema(description = "댓글 ID", example = "1")
  private Long id;

  @Schema(description = "게시글 ID", example = "10")
  private Long postId;

  @Schema(description = "댓글 생성일시", example = "2024-07-07")
  private LocalDateTime createAt;

  @Schema(description = "댓글 내용", example = "노래 좋아요!")
  private String content;

  @Schema(description = "댓글 작성자", example = "나경")
  private String writer;
}
