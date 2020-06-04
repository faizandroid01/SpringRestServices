package com.faiz.learn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faiz.learn.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
