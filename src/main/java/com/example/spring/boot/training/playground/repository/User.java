package com.example.spring.boot.training.playground.repository;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.example.spring.boot.training.playground.repository.User.*;

@Entity
@Table(name = TABLE_NAME)
@Getter
@ToString
public class User {

    public final static String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    /**
     * Required by JPA / Hibernate
     */
    protected User() {
    }

    public User(String name) {
        this.name = name;
    }
}
