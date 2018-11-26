package com.smart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import com.smart.domain.Forum;
import com.smart.domain.Post;

@ContextConfiguration(locations = ( "classpath:ApplicationContext.xml"))
@Rollback
@Transactional
public class ForumDaoTest extends AbstractTransactionalTestNGSpringContextTests{
	@Autowired
	private ForumDao forumDao;
	@Test
	public void testAddForum() throws Throwable{
		Forum forum = new Forum();
		forum.setForumName("test");
		forum.setForumDesc("desc");
		forumDao.addForumByNamedParams(forum);
	}
}