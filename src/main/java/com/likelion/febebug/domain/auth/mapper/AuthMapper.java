package com.likelion.febebug.domain.auth.mapper;

import com.likelion.febebug.domain.auth.dto.response.LoginResponse;
import com.likelion.febebug.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {

  public LoginResponse toLoginResponse(User user, String accessToken, Long expirationTime) {
    return LoginResponse.builder()
        .accessToken(accessToken)
        .userId(user.getId())
        .email(user.getEmail())
        .role(user.getRole())
        .expirationTime(expirationTime)
        .build();
  }
}
