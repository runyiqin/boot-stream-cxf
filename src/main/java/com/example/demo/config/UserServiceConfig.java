package com.example.demo.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;

@Configuration
public class UserServiceConfig {

	  @Bean
	    public ServletRegistrationBean dispatcherServlet(){
	        return new ServletRegistrationBean(new CXFServlet(),"/demo/*");//发布服务名称
	    }

	    @Bean(name = Bus.DEFAULT_BUS_ID)
	    public SpringBus springBus()
	    {
	        return  new SpringBus();
	    }

	    @Bean
	    public UserService userService()
	    {
	        return  new UserServiceImpl();
	    }

	    @Bean
	    public Endpoint endpoint() {
	        EndpointImpl endpoint=new EndpointImpl(springBus(), userService());//绑定要发布的服务
	        endpoint.publish("/user"); //显示要发布的名称
	        return endpoint;
	    }
}
