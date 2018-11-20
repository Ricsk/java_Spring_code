package com.smart.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.CallableStatementCreatorFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

public class TopicDao{
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public double getReplyRate(int userId) {
		String sql = "select topic_replies, topic_views from t_topic where user_id=?";
		double rate =  jdbcTemplate.queryForObject(sql, new Object[] {userId}, 
				new RowMapper<Double>() {
					public Double mapRow(ResultSet rs, int index) throws SQLException{
						int replies = rs.getInt("topic_replies");
						int views = rs.getInt("topic_views");
						if(views > 0)
							return new Double((double)replies/views);
						else
							return new Double(0.0);
					}
		});
		return rate;
	}
	
	public int getUserTopicNum(final int userId) {
		String sql = "{call P_GET_TOPIC_NUM(?,?)}";
		Integer num = jdbcTemplate.execute(sql, new CallableStatementCallback<Integer>() {
			public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException{
				cs.setInt(1, userId);
				cs.registerOutParameter(2, Types.INTEGER);
				cs.execute();
				return cs.getInt(2);
			}
		});
		return num;
	}
	
	public int getUserTopicNum2(final int userId) {
		String sql = "{call P_GET_TOPIC_NUM(?,?)}";
		CallableStatementCreatorFactory fac = new CallableStatementCreatorFactory(sql);
		fac.addParameter(new SqlParameter("userId", Types.INTEGER));
		fac.addParameter(new SqlOutParameter("topicNum", Types.INTEGER));
		Map<String, Integer>ParamsMap = new HashMap<String, Integer>();
		ParamsMap.put("userId", userId);
		CallableStatementCreator csc = fac.newCallableStatementCreator(ParamsMap);
		Integer num = jdbcTemplate.execute(csc, new CallableStatementCallback<Integer>() {
			public Integer doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException{
				cs.execute();
				return cs.getInt(2);
			}
		});
		return num;
	}
}