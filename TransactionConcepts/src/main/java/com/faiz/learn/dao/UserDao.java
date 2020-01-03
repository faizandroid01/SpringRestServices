package com.faiz.learn.dao;

import org.springframework.stereotype.Repository;

import com.faiz.learn.Entity.User;

@Repository
public interface UserDao {

	User createUser(User user);

	User findUserWith(String userPid);

}
