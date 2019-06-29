package com.example.demo.model;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class UserVerifyResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4647896351247623333L;

	@XStreamAlias("Status")
	private String status;
	
	@XStreamAlias("UserName")
	private String userName;
	
	@XStreamAlias("Errormsg")
	private String errormsg;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	
	
}
