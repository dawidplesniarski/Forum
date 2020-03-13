package com.example.plesniar.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class PostDto {
  Long id;
  String content;
  String userLogin;
  String topic;
  LocalDateTime date;

  public PostDto(){}

  @Override
  public String toString() {
    return id + " " + content + " " + userLogin + " " + date;
  }
}
