package com.example.plesniar.service;

import com.example.plesniar.domain.dto.PostDto;
import com.example.plesniar.domain.model.Post;
import com.example.plesniar.domain.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

  private final PostRepository postRepository;

  @Autowired
  public PostService(@Autowired PostRepository postRepository) {
    this.postRepository = postRepository;
  }


  public PostDto addPost(String userLogin, String content, String topic) {
    final Post post = new Post(content, topic, userLogin, LocalDateTime.now());
    final Post savedPost = postRepository.save(post);

    return new PostDto(savedPost.getId(), savedPost.getContent(), savedPost.getTopic(), savedPost.getUserLogin(), savedPost.getDate());
  }


    public PostDto getPost(long postId) throws Exception {
      return postRepository.findById(postId)
              .orElseThrow(() -> new Exception("Post with Id: " + postId + " was not found")).dto();
    }

  public List<PostDto> findAll(){
    return postRepository.findAll().stream().map(Post::dto).collect(Collectors.toList());
    }

  }
