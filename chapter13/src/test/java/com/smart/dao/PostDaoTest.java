package com.smart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import com.smart.domain.Post;

@ContextConfiguration(locations = ( "classpath:ApplicationContext.xml"))
@Rollback
@Transactional
public class PostDaoTest extends AbstractTransactionalTestNGSpringContextTests{
	@Autowired
	private PostDao postDao;
	//@Test
	public void testAddPost() throws Throwable{
		Post post = new Post();
		post.setUserId(2);
		ClassPathResource res = new ClassPathResource("temp.jpg");
		byte[] mockImg = FileCopyUtils.copyToByteArray(res.getFile());
		post.setPostAttach(mockImg);
		post.setPostText("测试帖子呢内容");
		//System.out.println(post.getUserId());
		postDao.addPost(post);
	}
}