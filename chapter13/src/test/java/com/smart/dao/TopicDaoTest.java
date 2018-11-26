package com.smart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

@ContextConfiguration(locations = ( "classpath:ApplicationContext.xml"))
@Rollback
@Transactional
public class TopicDaoTest extends AbstractTransactionalTestNGSpringContextTests{
	@Autowired
	private TopicDao topicDao;
	//@Test
	public void testGetTopicRowSet() {
		SqlRowSet srs = topicDao.getTopicRowSet(1);
		
		//此时数据连接已经断开
		while(srs.next()) {
			System.out.println(srs.getString("topic_id"));
		}
	}
}