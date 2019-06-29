package com.example.demo.service;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import com.example.demo.model.UserVerifyRequest;
import com.example.demo.model.UserVerifyResponse;
import com.example.demo.util.XstreamUtil;

public class UserServiceJunit {
	public static void main(String[] args) {
		// 创建动态客户端
		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
		Client client = factory.createClient("http://localhost:8080/demo/user?wsdl");
		// 需要密码的情况需要加上用户名和密码
		// client.getOutInterceptors().add(new
		// ClientLoginInterceptor(USER_NAME,PASS_WORD));
		HTTPConduit conduit = (HTTPConduit) client.getConduit();
		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
		httpClientPolicy.setConnectionTimeout(2000); // 连接超时
		httpClientPolicy.setAllowChunking(false); // 取消块编码
		httpClientPolicy.setReceiveTimeout(120000); // 响应超时
		conduit.setClient(httpClientPolicy);
		// client.getOutInterceptors().addAll(interceptors);//设置拦截器
		try {

			UserVerifyRequest userRequest = new UserVerifyRequest();
			userRequest.setPassword("111111");
			userRequest.setUsername("测试用户");

			String xmlString = XstreamUtil.toXml(UserVerifyRequest.class, userRequest);

			System.out.println(xmlString);

			Object[] objects = new Object[0];
			// invoke("方法名",参数1,参数2,参数3....);
			objects = client.invoke("userVerify", xmlString);
			System.out.println("返回数据:" + objects[0]);

			UserVerifyResponse ss = (UserVerifyResponse) XstreamUtil.toBean(UserVerifyResponse.class, objects[0] + "");
			System.out.println(ss.getUserName());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
