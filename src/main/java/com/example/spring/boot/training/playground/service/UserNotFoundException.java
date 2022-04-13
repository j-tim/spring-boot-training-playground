package com.example.spring.boot.training.playground.service;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {

    private Long userId;

    public UserNotFoundException(Long userId) {
        super(String.format("User with id: %d is not found.", userId));
        this.userId = userId;
    }
}
