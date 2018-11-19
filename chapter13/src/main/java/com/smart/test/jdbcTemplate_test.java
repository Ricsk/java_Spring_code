package com.smart.test;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class jdbcTemplate_test{
	public static void main(String [] args) {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3309/sampledb2");
		ds.setUsername("root");
		ds.setPassword("rootroot");
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(ds);
		
		String sql = "create table t_user(user_id int primary key, user_name varchar(60))";
		jdbcTemplate.execute(sql);
	}
}