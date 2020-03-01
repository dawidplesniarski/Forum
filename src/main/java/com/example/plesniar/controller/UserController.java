package com.example.plesniar.controller;

import com.example.plesniar.domain.dto.PostDto;
import com.example.plesniar.domain.dto.UserDto;
import com.example.plesniar.exception.UserNotLoggedException;
import com.example.plesniar.service.PostService;
import com.example.plesniar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class UserController {

  private final UserService userService;
  private final PostService postService;
  private UserDto loggedUser;

  @Autowired
  public UserController(@Autowired UserService userService, PostService postService) {
    this.userService = userService;
    this.postService = postService;
    //this.loggedUser = new UserDto(0L, "NIEPRAWIDLOWY");
  }

  @PostMapping("/login")
  public ResponseEntity<UserDto> loginUser(@RequestBody String login) {
    final UserDto user = userService.loginUser(login);
    loggedUser = user;

    return ResponseEntity.ok(user);
  }

  @PostMapping("/addPost")
  public ResponseEntity<PostDto> addPost(@RequestBody String content){
    if(loggedUser.getLogin() == null) throw new UserNotLoggedException();

    final PostDto post = postService.addPost(loggedUser.getLogin(),content);

    return ResponseEntity.ok(post);
  }
}
