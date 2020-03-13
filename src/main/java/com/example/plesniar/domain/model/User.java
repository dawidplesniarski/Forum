package com.example.plesniar.domain.model;

import com.example.plesniar.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.security.MessageDigest;

@Entity
@Table(name = "users2")
@AllArgsConstructor
@Getter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  String login;
  String password;

  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public User() {}


  public UserDto dto() {
    return new UserDto(userId, login, password);
  }
}
