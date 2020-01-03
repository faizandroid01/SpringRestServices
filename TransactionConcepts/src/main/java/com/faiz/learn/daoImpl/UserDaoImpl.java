package com.faiz.learn.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.faiz.learn.Entity.User;
import com.faiz.learn.Repo.UserRepo;
import com.faiz.learn.dao.UserDao;
import com.faiz.learn.exception.ResourceNotFoundException;

@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User findUserWith(String userPid) {
		return userRepo.findUserByUserPid(userPid);
	}

}
