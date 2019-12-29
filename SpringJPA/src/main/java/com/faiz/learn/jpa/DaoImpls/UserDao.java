package com.faiz.learn.jpa.DaoImpls;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.faiz.learn.jpa.EntityModel.User;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager em;

	public User insertUser(User user) {

		em.persist(user);

		return user;
	}

}
