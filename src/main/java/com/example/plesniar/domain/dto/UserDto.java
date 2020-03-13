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

//  public String getLogin() {
//    return login;
//  }

  //all args constructor
//  public UserDto(Long userId, String login, int age) {
//    this.userId = userId;
//    this.login = login;
//    this.age = age;
//  }

  //required constructor
//  public UserDto(Long userId, String login) {
//    this.userId = userId;
//    this.login = login;
//  }
}
