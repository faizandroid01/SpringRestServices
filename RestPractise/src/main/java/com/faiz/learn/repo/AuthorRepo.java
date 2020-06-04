package com.faiz.learn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faiz.learn.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

}
