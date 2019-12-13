package exception;

import java.util.Date;

public class GenericExceptionModel {

	private Date timestamp;
	private String exceptionMsg;
	private String details;

	public GenericExceptionModel(Date timestamp, String exceptionMsg, String details) {
		super();
		this.timestamp = timestamp;
		this.exceptionMsg = exceptionMsg;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public String getDetails() {
		return details;
	}

}
