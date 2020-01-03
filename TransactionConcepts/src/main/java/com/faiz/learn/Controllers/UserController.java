package com.faiz.learn.Controllers;

import java.net.URI;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.faiz.learn.Entity.Posts;
import com.faiz.learn.Entity.User;
import com.faiz.learn.Models.UserWithPosts;
import com.faiz.learn.Service.PostService;
import com.faiz.learn.Service.UserService;
import com.faiz.learn.exception.ResourceNotFoundException;

@RestController
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;

	@GetMapping(value = "/test")
	public String testApi() {
		return "response SuccessFul";
	}

	@PostMapping(value = "/users")
	public ResponseEntity<User> createUser(@RequestBody User user) throws SQLException {

		LOGGER.info("User Controller - createUser");

		user.setCreatedOn(new Timestamp(new Date().getTime()));

		User createdUser = userService.createUser(user);

		if (null == createdUser)
			throw new SQLException("Sql Error");

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdUser.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping("/users/{userPid}")
	private User retrieveUser(@PathVariable String userPid) {

		LOGGER.info("User Controller - retrieveUser");

		User user = userService.findUserByUserPid(userPid);

		if (user != null)
			return user;
		else
			throw new ResourceNotFoundException("UserPid : " + userPid + " doesnt exist .");

	}

	@PostMapping(value = "/usersWithPosts")
	public ResponseEntity<User> createUserWithPosts(@RequestBody UserWithPosts userWithPosts) throws SQLException {
		LOGGER.info("User Controller - createUserWithPosts");

		UserWithPosts createdUser = userService.createUserWithPosts(userWithPosts);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userWithPosts.getUser().getId()).toUri();

		return ResponseEntity.created(location).build();

	}

}
