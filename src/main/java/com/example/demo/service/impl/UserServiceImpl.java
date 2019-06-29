package com.example.demo.service.impl;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.example.demo.model.UserVerifyRequest;
import com.example.demo.model.UserVerifyResponse;
import com.example.demo.service.UserService;
import com.example.demo.util.XstreamUtil;

@WebService(serviceName = "UserService",targetNamespace="http://service.demo.example.com/",endpointInterface = "com.example.demo.service.UserService")
public class UserServiceImpl implements UserService{

	@WebMethod
    public String sayHello(String user) {
		   return user+"，现在时间："+"("+new Date()+")";
	}
	
	@WebMethod
	public String userVerify(String request) {
		UserVerifyRequest userVerifyRequest = (UserVerifyRequest) XstreamUtil.toBean(UserVerifyRequest.class, request);
		UserVerifyResponse response = new UserVerifyResponse();
		response.setStatus("0");
		response.setUserName(userVerifyRequest.getUsername());
		response.setErrormsg("");
		return XstreamUtil.toXml(UserVerifyResponse.class, response);
	}
}

