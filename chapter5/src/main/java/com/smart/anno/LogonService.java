package com.smart.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
@Service
public class LogonService{
	
	private LogDao logDao;
	private UserDao userDao;
	
	
	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
}
