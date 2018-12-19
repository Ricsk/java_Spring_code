package com.smart.service;

import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.unitils.spring.annotation.SpringBean;

import com.smart.dao.PostDao;
import com.smart.domain.Board;
import com.smart.domain.Topic;
import com.smart.domain.User;
import com.smart.test.dataset.util.XlsDataSetBeanFactory;

public class ForumServiceTest extends BaseServiceTest{
	@SpringBean("forumService")
	private ForumService forumService;
	@SpringBean("userService")
	private UserService userService;
	
	@BeforeMethod(enabled = false)
	public void init() {
		SessionFactory sf = hibernateTemplate.getSessionFactory();
		Map<String, CollectionMetadata> roleMap = sf.getAllCollectionMetadata();
		for(String roleName : roleMap.keySet()) {
			sf.evictCollection(roleName);
		}
		Map<String, ClassMetadata> entityMap = sf.getAllClassMetadata();
		for(String entityName : entityMap.keySet()) {
			sf.evictEntity(entityName);
			
		}
		sf.evictQueries();
	}
	
	@Test(enabled = false)
	public void addBoard() throws Exception{
		Board board = XlsDataSetBeanFactory.createBean(ForumServiceTest.class, 
				"XiaoChun.DataSet.xls", "t_board", Board.class);
		forumService.addBoard(board);
		Board boardDb = forumService.getBoardById(board.getBoardId());
		Assert.assertEquals(boardDb.getBoardName(), "育儿");
		//System.out.println(boardDb.getBoardName());
	}

	@Test
	public void addTopics() throws Exception{
		Board board = XlsDataSetBeanFactory.createBean(ForumServiceTest.class, 
				"XiaoChun.DataSet.xls", "t_board", Board.class);
		forumService.addBoard(board);
		Topic topic = XlsDataSetBeanFactory.createBean(ForumServiceTest.class, 
				"XiaoChun.DataSet.xls","t_topic", Topic.class);
		User user = XlsDataSetBeanFactory.createBean(ForumServiceTest.class, 
				"XiaoChun.DataSet.xls", "t_user", User.class);
		System.out.println(topic.getTopicTitle());
		System.out.println(user.getUserName());
		forumService.addBoard(board);
		userService.register(user);
		topic.setUser(user);
		topic.setBoard(board);
		forumService.addTopic(topic);
		Board boardDb = forumService.getBoardById(board.getBoardId());
		User userDb = userService.getUserByUserName("tom");
		System.out.println(board.getBoardId());
		System.out.println(boardDb.getTopicNum());
		System.out.println(userDb.getCredit());
		System.out.println(topic.getTopicId());
	}
	
}