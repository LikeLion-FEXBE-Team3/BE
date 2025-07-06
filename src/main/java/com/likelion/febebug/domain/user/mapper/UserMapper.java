package com.likelion.febebug.domain.user.mapper;

import com.likelion.febebug.domain.user.dto.response.SignUpResponse;
import com.likelion.febebug.domain.user.dto.response.UserResponse;
import com.likelion.febebug.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public SignUpResponse toSignUpResponse(User user) {
    return SignUpResponse
        .builder()
        .userId(user.getId())
        .email(user.getEmail())
        .build();
  }

  public UserResponse toUserResponse(User user) {
    return UserResponse
        .builder()
        .id(user.getId())
        .nickname(user.getNickname())
        .nation(user.getNation())
        .selfIntro(user.getSelfIntro())
        .build();
  }
}
