package com.example.plesniar.domain.repositories;

import com.example.plesniar.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
