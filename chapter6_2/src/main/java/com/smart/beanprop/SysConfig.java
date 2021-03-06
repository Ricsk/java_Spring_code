package com.smart.beanprop;

import javax.sql.DataSource;

public class SysConfig{
	private int sessionTimeout;
	private int maxTabPageNum;
	private DataSource dataSource;
	
	//模拟从数据库中获取配置值并设置相应的属性
	public void initFromDB() {
		this.sessionTimeout = 30;
		this.maxTabPageNum = 10;
	}
	
	public int getSessionTimeout() {
		return this.sessionTimeout;
	}
	
	public int getMaxTabPageNum() {
		return this.maxTabPageNum;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}