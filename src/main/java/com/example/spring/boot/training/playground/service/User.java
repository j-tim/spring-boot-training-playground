package com.example.spring.boot.training.playground.service;

import com.example.spring.boot.training.playground.annotations.Default;
import lombok.Getter;

@Getter
public class User {

    private final Long id;
    private final String name;

    public User(String name) {
        this(null, name);
    }

    @Default
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
