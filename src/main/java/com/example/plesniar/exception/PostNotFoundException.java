package com.example.plesniar.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String s) {
        System.out.println("Post not found");
    }
}
