package com.example.plesniar.controller;

import com.example.plesniar.domain.dto.PostDto;
import com.example.plesniar.domain.dto.UserDto;
import com.example.plesniar.domain.model.NewMessage;
import com.example.plesniar.domain.model.NewUser;
import com.example.plesniar.exception.UserNotLoggedException;
import com.example.plesniar.service.PostService;
import com.example.plesniar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

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
  }

  @PostMapping("/login")
  public ResponseEntity<UserDto> loginUser(@RequestBody NewUser newUser) throws NoSuchAlgorithmException {
    final UserDto user = userService.loginUser(newUser.getLogin(),newUser.getPassword());
    loggedUser = user;

    return ResponseEntity.ok(user);
  }

  @PostMapping("/addPost")
  public ResponseEntity<PostDto> addPost(@RequestBody NewMessage newMessage){
    Optional.ofNullable(loggedUser.getLogin()).orElseThrow(UserNotLoggedException::new);
    final PostDto post = postService.addPost(loggedUser.getLogin(), newMessage.getMessage(), newMessage.getTopic());

    return ResponseEntity.ok(post);
  }

  @GetMapping("/getPost/{id}")
  @ResponseBody
  public ResponseEntity<PostDto> getPosts(@PathVariable Long id) throws Exception {
    final PostDto post = postService.getPost(id);
    System.out.println(post.toString());

    return ResponseEntity.ok(post);
  }

  @GetMapping("/getAllPosts")
  @ResponseBody
  public ResponseEntity<List<PostDto>> getAllPosts(){
    List<PostDto> posts = postService.findAll();
    return ResponseEntity.ok(posts);
  }

  @GetMapping("/getPostByTopic/{topic}")
  @ResponseBody
  public ResponseEntity<List<PostDto>> getPostByTopic(@PathVariable String topic){
    System.out.println("Controller: " + topic);
    List<PostDto> postDto = postService.getPostByTopic(topic);

    return ResponseEntity.ok(postDto);
  }
}
