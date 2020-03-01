package com.example.plesniar.domain.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts2")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String content;
  String userLogin;
  @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE NOT NULL")
  LocalDateTime date;

  public Post() {
  }

  public Post(String content, String userLogin, LocalDateTime date) {
    this.content = content;
    this.userLogin = userLogin;
    this.date = date;
  }

  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public String getUserLogin() {
    return userLogin;
  }

  public LocalDateTime getDate() {
    return date;
  }
}
