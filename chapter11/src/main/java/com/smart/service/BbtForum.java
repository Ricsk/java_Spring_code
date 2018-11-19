package com.smart.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.dao.*;
import com.smart.domain.*;
@Service
//@Transactional
public class BbtForum{
	public ForumDao forumDao;
	public TopicDao topicDao;
	public PostDao postDao;
	//@Transactional("topic")
	@TopicTransactional
	public void addTopic(Topic topic) {
		topicDao.addTopic(topic);
		postDao.addPost(topic.getPost());
	}
	public Forum getForum(int forumId) {
		return forumDao.getForum(forumId);
	}
	//@Transactional("forum")
	@ForumTransactional
	public void updateForum(Forum forum) {
		forumDao.updateForum(forum);
	}
	public int getForumNum() {
		return forumDao.getForumNum();
	}
}