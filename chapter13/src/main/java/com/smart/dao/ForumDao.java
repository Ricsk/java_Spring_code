package com.smart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ForumDao{
	private JdbcTemplate jdbcTemplate;
	private final String sql = "create table t_user(user_id int primary key, user_name varchar(60))";
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void initDb() {
		jdbcTemplate.execute(sql);
	}
}