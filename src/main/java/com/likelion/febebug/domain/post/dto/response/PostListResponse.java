package com.likelion.febebug.domain.post.dto.response;

import com.likelion.febebug.domain.comment.dto.response.CommentResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(title = "PostListResponse", description = "게시글 목록 응답 DTO")
public class PostListResponse {

  @Schema(description = "음식 응답 리스트")
  private List<PostResponse> posts;

  private List<CommentResponse> comments;
}