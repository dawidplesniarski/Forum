package com.example.plesniar.domain.model;

import com.example.plesniar.domain.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts2")
@Getter
@AllArgsConstructor
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

  public Post(String content, String userLogin, LocalDateTime now) {
  }

//  public Long getId() {
//    return id;
//  }
//
//  public String getContent() {
//    return content;
//  }
//
//  public String getUserLogin() {
//    return userLogin;
//  }
//
//  public LocalDateTime getDate() {
//    return date;
//  }

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
