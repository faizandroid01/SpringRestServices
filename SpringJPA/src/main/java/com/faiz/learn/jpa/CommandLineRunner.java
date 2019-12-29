package com.faiz.learn.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.faiz.learn.jpa.EntityModel.User;
import com.faiz.learn.jpa.Repository.UserRepository;
import com.faiz.learn.jpa.Services.UserService;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(CommandLineRunner.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository UserRepository;

	@Override
	public void run(String... args) throws Exception {

		User user = new User("Faiz");
		log.info("New user is being created :" + user.getUserId() + " : " + user.getUserName());

		User serviceInsertedUser = userService.insertUser(user);
		log.info("service user is created :" + serviceInsertedUser.getUserId() + " : "
				+ serviceInsertedUser.getUserName());

		User getUserByRepo = UserRepository.findById(serviceInsertedUser.getUserId()).get();

		log.info("getting service created : " + getUserByRepo.getUserId() + ":" + getUserByRepo.getUserName());

		getUserByRepo.setUserName("dravi jain");

		User newUser = UserRepository.save(getUserByRepo);
		log.info("repo user is created :" + newUser.getUserId() + " : " + newUser.getUserName());

		// tweaking primary key

		getUserByRepo.setUserId(2);

		User afterTweakingPK = UserRepository.save(getUserByRepo);
		log.info("repo user is created :" + afterTweakingPK.getUserId() + " : " + afterTweakingPK.getUserName());

	}

}
