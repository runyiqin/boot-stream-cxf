package com.example.demo.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name="UserService")
public interface UserService {

	@WebMethod
    public String sayHello(String ss);
	
	@WebMethod
	public String userVerify(String request);
}
