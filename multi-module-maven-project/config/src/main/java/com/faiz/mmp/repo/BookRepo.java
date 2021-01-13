package com.faiz.mmp.repo;

import org.springframework.data.repository.CrudRepository;

import com.faiz.mmp.models.Book;

public interface BookRepo extends CrudRepository<Book, Long> {

}
