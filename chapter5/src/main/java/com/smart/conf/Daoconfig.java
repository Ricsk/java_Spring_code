package com.smart.conf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
public class Daoconfig{
	
	@Scope("prototype")
	@Bean
	public UserDao userDao() {
		return new UserDao();
	}
	public LogDao logDao(){
		return new LogDao();
	}
}