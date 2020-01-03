package com.faiz.learn.exception;

import java.util.Date;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	private Date timestamp;
	private String exceptionMsg;
	private String details;

	public CustomException() {
		super();
	}

	public CustomException(Date timestamp, String exceptionMsg, String details) {
		super();
		this.timestamp = timestamp;
		this.exceptionMsg = exceptionMsg;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
