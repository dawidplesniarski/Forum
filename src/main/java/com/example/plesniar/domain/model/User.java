package com.example.plesniar.domain.model;

import com.example.plesniar.domain.dto.UserDto;

import javax.persistence.*;

@Entity
@Table(name = "users2")
public class User {

  public User() {
  }

  public User (String login) {
    this.login = login;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  String login;

  public Long getUserId() {
    return userId;
  }

  public UserDto dto() {
    return new UserDto(userId, login);
  }
}
