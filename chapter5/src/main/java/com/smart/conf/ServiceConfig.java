package com.smart.conf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
@Configuration
public class ServiceConfig{
	
	@Autowired
	private Daoconfig daoConfig;
	
	@Bean
	public LogonService logonService() {
		LogonService logonService = new LogonService();
		
		logonService.setLogDao(daoConfig.logDao());
		logonService.setUserDao(daoConfig.userDao());
		return logonService;
	}
}