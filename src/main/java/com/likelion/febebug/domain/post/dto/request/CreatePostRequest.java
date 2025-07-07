package com.likelion.febebug.domain.post.dto.request;

import com.likelion.febebug.domain.post.entity.Genre;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
@Schema(title = "CreatePostRequest: 게시글 생성 요청 DTO")
public class CreatePostRequest {

  @NotBlank(message = "제목은 비어 있을 수 없습니다.")
  @Size(max = 60, message = "게시글 제목은 60자 이하로 입력해야 합니다.")
  @Schema(description = "게시글 제목", example = "alldayproject 노래 추천")
  private String title;

  @NotBlank(message = "내용은 비어 있을 수 없습니다.")
  @Size(max = 255, message = "게시글 내용은 255자 이하로 입력해야 합니다.")
  @Schema(description = "게시글 내용", example = "다들 들어봐")
  private String description;

  @NotBlank(message = "작성자는 비어 있을 수 없습니다.")
  @Schema(description = "작성자", example = "감자")
  private String writer;

  @NotNull(message = "장르를 선택해주세요.")
  @Schema(description = "게시글 장르", example = "DANCE")
  private Genre genre;

  @Schema(description = "이미지 URL", example = "https://example.com/image.jpg")
  private String imageUrl;
}