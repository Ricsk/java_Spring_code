package com.smart.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.smart.domain.Post;


@Repository
public class PostDao{
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void addPost(final Post post) {
		String sql = " INSERT INTO t_post(topic_id, post_text) VALUES(?,?)";
		Object[] params = new Object[] {post.getTopicId(),post.getPostText()};
		jdbcTemplate.update(sql,params);
	}
}