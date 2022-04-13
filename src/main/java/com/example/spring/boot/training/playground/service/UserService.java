package com.example.spring.boot.training.playground.service;

import com.example.spring.boot.training.playground.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository) {
        this(userRepository, UserMapper.INSTANCE);
    }

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User getUser(Long id) {
        com.example.spring.boot.training.playground.repository.User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return userMapper.map(user);
    }

    public User create(User user) {
        com.example.spring.boot.training.playground.repository.User savedUser = userRepository.save(new com.example.spring.boot.training.playground.repository.User(user.getName()));
        return userMapper.map(savedUser);
    }
}
