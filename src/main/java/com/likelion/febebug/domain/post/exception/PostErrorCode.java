package com.likelion.febebug.domain.post.exception;

import com.likelion.febebug.global.exception.model.BaseErrorCode;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum PostErrorCode implements BaseErrorCode {
  POST_NOT_FOUND("POST_404_01", "해당 게시물을 찾을 수 없습니다", HttpStatus.NOT_FOUND);

  private final String code;
  private final String message;
  private final HttpStatus status;
}
