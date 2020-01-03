package com.faiz.learn.Service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faiz.learn.Entity.User;
import com.faiz.learn.Models.UserWithPosts;

@Service
public interface UserService {

	User createUser(User user);

	User findUserByUserPid(String userPid);

	@Transactional
	UserWithPosts createUserWithPosts(UserWithPosts userWithPosts) throws SQLException;

}
