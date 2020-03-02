package com.example.plesniar.service;

import com.example.plesniar.domain.dto.PostDto;
import com.example.plesniar.domain.model.Post;
import com.example.plesniar.domain.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

  private final PostRepository postRepository;

  @Autowired
  public PostService(@Autowired PostRepository postRepository) {
    this.postRepository = postRepository;
  }


  public PostDto addPost(String userLogin, String content) {
    final Post post = new Post(content, userLogin, LocalDateTime.now());
    final Post savedPost = postRepository.save(post);
    return new PostDto(savedPost.getId(), savedPost.getContent(), savedPost.getUserLogin(), savedPost.getDate());
  }


    public PostDto getPost(long postId) throws Exception {
      return postRepository.findById(postId)
              .orElseThrow(() -> new Exception("Post with Id: " + postId + " was not found")).dto();
    }
  }

  //1. do kontrolera usera dodaj metode addPost, pamietaj o pobraniu zalogowanego usera
  //2. dodaj metode getPost w service a potem w kontrolerze -> zwraca PostDto, pobiera post po long id, wyszukuje Post w bazie, zmienia na PostDto i zwraca ten dto, pamietaj o wyjatkach nullach itp

