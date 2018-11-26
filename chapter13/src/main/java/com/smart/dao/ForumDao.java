package com.smart.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.smart.domain.Forum;

@Repository
public class ForumDao{
	private JdbcTemplate jdbcTemplate;
	private final String sql1 = "create table t_user(user_id int primary key , user_name varchar(60))";
	private final String sql2 = "insert int t_forum(forum_name, forum_desc) VALUES(?,?)";
	private final String sql3 = "insert into t_forum(forum_name, forum_desc)"
			+"values(:forumName, :forumDesc)";
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public void addForumByNamedParams(final Forum forum) {
		SqlParameterSource sps = new BeanPropertySqlParameterSource(forum);
		namedParameterJdbcTemplate.update(sql3, sps);
	}
	public void addForum(Forum forum) {
		Object [] params = new Object[] {forum.getForumName(), forum.getForumDesc()};
		jdbcTemplate.update(sql2, params, new int[] {Types.VARCHAR, Types.VARCHAR});
	}
	
	public void addForum2(final Forum forum) {
		jdbcTemplate.update(sql2, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setString(1,  forum.getForumName());
				ps.setString(2,  forum.getForumDesc());
			}
		});
	}
	
	public void addForum3(final Forum forum) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection conn) 
					throws SQLException{
				PreparedStatement ps = conn.prepareStatement(sql2);
				ps.setString(1,  forum.getForumName());
				ps.setString(2, forum.getForumDesc());
				return ps;
			}
		}
		);
	}
	public void addForum4(final Forum forum) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
				PreparedStatement ps = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,  forum.getForumName());
				ps.setString(2,  forum.getForumDesc());
				return ps;
			}
		}, keyHolder);
		forum.setForumId(keyHolder.getKey().intValue());
	}
	
	public void addForums(final List<Forum> forums) {
		jdbcTemplate.batchUpdate(sql2, new BatchPreparedStatementSetter() {
			public int getBatchSize() {
				return forums.size();
			}
			
			public void setValues(PreparedStatement ps, int index) throws SQLException{
				Forum forum = forums.get(index);
				ps.setString(1, forum.getForumName());
				ps.setString(2, forum.getForumDesc());
			}
		});
	}
	
	public Forum getForum(final int forumId) {
		String sql = "select forum_name, forum_desc from t_forum where forum_id=?";
		final Forum forum = new Forum();
		jdbcTemplate.query(sql, new Object[] {forumId}, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException{
				forum.setForumId(forumId);
				forum.setForumName(rs.getString("forum_name"));
				forum.setForumDesc(rs.getString("forum_desc"));
			}
		}
		);
		return forum;
	}
	
	public List<Forum> getForums(final int fromId, final int toId){
		String sql = "select froum_id, forum_name, forum_desc from t_forum where "
				+ "forum_id between ? and ?";
		final List forums = new ArrayList();
		jdbcTemplate.query(sql, new Object[] {fromId, toId}, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException{
				Forum forum = new Forum();
				forum.setForumId(rs.getInt("forum_id"));
				forum.setForumName(rs.getString("forum_name"));
				forum.setForumDesc(rs.getNString("forum_desc"));
				forums.add(forum);
			}
		});
		return forums;
	}
	
	public List<Forum> getForums2(final int fromId, final int toId){
		String sql = "select forum_id, forum_name, forum_desc from t_forum where "
				+" forum_id between ? and ?";
		return jdbcTemplate.query(sql, new Object[] {fromId, toId}, new RowMapper<Forum>() {
			public Forum mapRow(ResultSet rs, int index) throws SQLException{
				Forum forum = new Forum();
				forum.setForumId(rs.getInt("forum_id"));
				forum.setForumName(rs.getString("forum_name"));
				forum.setForumDesc(rs.getString("forum_desc"));
				return forum;
			}
		});
	}
	
	
	public void initDb() {
		jdbcTemplate.execute(sql1);
	}
}