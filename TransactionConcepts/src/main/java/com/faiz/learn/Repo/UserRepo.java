package com.faiz.learn.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.faiz.learn.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	@Query(value = "select * from vfx_user where userPid = ?1", nativeQuery = true)
	public User findUserByUserPid(String userPid);

}
