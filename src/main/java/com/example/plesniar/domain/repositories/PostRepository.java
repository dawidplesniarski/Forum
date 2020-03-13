package com.example.plesniar.domain.repositories;

import com.example.plesniar.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.topic = :topic")
    List<Post> findPostsByTopicName(String topic);

}
