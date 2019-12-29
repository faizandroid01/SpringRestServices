package com.faiz.learn.jpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.faiz.learn.jpa.EntityModel.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
