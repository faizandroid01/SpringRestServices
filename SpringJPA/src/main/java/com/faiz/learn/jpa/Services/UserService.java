package com.faiz.learn.jpa.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faiz.learn.jpa.DaoImpls.UserDao;
import com.faiz.learn.jpa.EntityModel.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;

	public User insertUser(User user) {

		return userDao.insertUser(user);

	}

}
