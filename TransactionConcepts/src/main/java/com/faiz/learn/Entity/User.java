package com.faiz.learn.Entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vfx_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
	@SequenceGenerator(name = "author_generator", sequenceName = "user_seq")
	Long id;

	@NonNull
	String userName;

	@NonNull
	String userPid;

	@NonNull
	String controlFunction;

	@NonNull
	String dept;

	@NonNull
	@JsonIgnore
	private Timestamp createdOn;

	public User() {
		super();
	}

	public User(String userName, String userPid, String controlFunction, String dept, Timestamp createdOn) {
		super();
		this.userName = userName;
		this.userPid = userPid;
		this.controlFunction = controlFunction;
		this.dept = dept;
		this.createdOn = createdOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPid() {
		return userPid;
	}

	public void setUserPid(String userPid) {
		this.userPid = userPid;
	}

	public String getControlFunction() {
		return controlFunction;
	}

	public void setControlFunction(String controlFunction) {
		this.controlFunction = controlFunction;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

}
