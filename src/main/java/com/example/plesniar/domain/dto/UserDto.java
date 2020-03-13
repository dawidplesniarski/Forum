package com.example.plesniar.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class UserDto {

  private Long userId;
  private String login;
  private String password;

  public UserDto(Long userId, String login) {
  }
}
