package com.smart.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.smart.domain.Post;

@Repository
public class PostDao{
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	private LobHandler lobHandler;
	@Autowired
	public void setLobHandler(LobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}
	public void addPost(final Post post) {
		String sql = "insert into t_post(post_id, user_id, post_text, post_attach)"
				+ " values(?,?,?,?)";
		jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
			protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException{
				ps.setInt(1, 1);
				ps.setInt(2,  post.getUserId());
				lobCreator.setClobAsString(ps, 3, post.getPostText());
				lobCreator.setBlobAsBytes(ps, 4, post.getPostAttach());
			}
		});
	}
}