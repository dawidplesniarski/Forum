package com.example.plesniar.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder(toBuilder = true)
public class PostDto {
  Long id;
  String content;
  String userLogin;
  LocalDateTime date;


  @Override
  public String toString() {
    return id + " " + content + " " + userLogin + " " + date;
  }
}
