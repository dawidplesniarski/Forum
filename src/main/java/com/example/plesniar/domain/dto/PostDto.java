package com.example.plesniar.domain.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class PostDto {
  Long id;
  String content;
  String userLogin;
  LocalDateTime date;

}
