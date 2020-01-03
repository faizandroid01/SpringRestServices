package com.faiz.learn.Models;

import java.util.List;

import com.faiz.learn.Entity.Posts;
import com.faiz.learn.Entity.User;

public class UserWithPosts {

	private User user;
	private List<Posts> userPosts;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Posts> getUserPosts() {
		return userPosts;
	}

	public void setUserPosts(List<Posts> userPosts) {
		this.userPosts = userPosts;
	}

}
