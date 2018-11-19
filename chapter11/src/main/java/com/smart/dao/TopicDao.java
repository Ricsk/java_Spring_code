package com.smart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.smart.domain.Topic;

public class TopicDao{
/*	private static ThreadLocal<Connection> connThreadLocal = new ThreadLocal<Connection>();
	public static Connection getConnection() {
		if(connThreadLocal.get() == null) {
			Connection conn = DriverManager.getConnection();
			connThreadLocal.set(conn);
			return conn;
		}else {
			return connThreadLocal.get();
		}
	}
	
	public void addTopic() throws SQLException {
		Statement stat = getConnection().createStatement();
	}*/
	private JdbcTemplate jdbcTemplate;

	public void addTopic(final Topic topic) {
		final String sql = "INSERT INTO t_topic(topic_title) VALUES(?)";
		Object[] params = new Object[]{topic.getTopicTitle()};
		jdbcTemplate.update(sql, params);
	}
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
	