package com.example.plesniar.domain.model;

import com.example.plesniar.domain.dto.PostDto;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts2")
@Getter
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

  public PostDto dto() {
    return new PostDto(id, content, userLogin, date);
  }

//  public PostDto dto() {
//    return PostDto.builder()
//            .postId(id)
//            .content(content)
//            .createdOn(date)
//            .authorLogin(userLogin)
//            .build();
//  }
}
