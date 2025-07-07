package com.likelion.febebug.domain.comment.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "댓글 요청 DTO")
public class CommentRequest {

  @NotBlank
  @Schema(description = "댓글 내용", example = "노래 좋아요!")
  private String content;

  @NotBlank
  @Schema(description = "댓글 작성자", example = "나경")
  private String writer;
}
