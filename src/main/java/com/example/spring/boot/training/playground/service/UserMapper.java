package com.example.spring.boot.training.playground.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User map(com.example.spring.boot.training.playground.repository.User user);
}
