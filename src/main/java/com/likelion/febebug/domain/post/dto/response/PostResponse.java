package com.likelion.febebug.domain.post.dto.response;

import com.likelion.febebug.domain.comment.dto.response.CommentResponse;
import com.likelion.febebug.domain.comment.entity.Comment;
import com.likelion.febebug.domain.post.entity.Genre;
import com.likelion.febebug.domain.post.entity.Post;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(title = "PostResponse", description = "게시글 단일 응답 DTO")
public class PostResponse {

  @Schema(description = "게시글 ID", example = "1")
  private Long id;

  @Schema(description = "게시글 제목", example = "alldayproject 노래 추천")
  private String title;

  @Schema(description = "게시글 내용", example = "다들 들어봐")
  private String description;

  @Schema(description = "게시글 장르", example = "DANCE")
  private Genre genre;

  @Schema(description = "게시글 작성자", example = "감자")
  private String writer;

  @Schema(description = "게시글 내용", example = "다들 들어봐")
  private String imageUrl;

  @Schema(description = "게시글 작성 시각", example = "2025-07-07T02:08:00")
  private LocalDateTime createdAt;

  @Schema(description = "게시글 조회수", example = "123")
  private Long views;

  @Schema(description = "댓글 리스트 조회")
  private List<CommentResponse> comments;
}
