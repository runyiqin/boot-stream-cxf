package com.example.demo.model;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("request")
public class UserVerifyRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2796585561847218596L;

	@XStreamAlias("UserName")
	private String username;
	
	@XStreamAlias("Password")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
