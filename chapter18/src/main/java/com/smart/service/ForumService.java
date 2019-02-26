package com.smart.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.dao.BoardDao;
import com.smart.dao.Page;
import com.smart.dao.PostDao;
import com.smart.dao.TopicDao;
import com.smart.dao.UserDao;
import com.smart.domain.Board;
import com.smart.domain.MainPost;
import com.smart.domain.Post;
import com.smart.domain.Topic;
import com.smart.domain.User;

@Service
public class ForumService{
	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private PostDao postDao;
	
	@Autowired
	private UserDao userDao;
	
	public void addTopic(Topic topic){
		Board board = topic.getBoard();
		board.setTopicNum(board.getTopicNum() + 1);
		topicDao.save(topic);
		boardDao.update(board);
		topic.getMainPost().setTopic(topic);
		MainPost post = topic.getMainPost();
		post.setCreateTime(new Date());
		post.setUser(topic.getUser());
		post.setPostTitle(topic.getTopicTitle());
		post.setBoardId(topic.getBoard().getBoardId());
		post.setPostText("sssss");
		postDao.save(topic.getMainPost());
		
		User user = topic.getUser();
		user.setCredit(user.getCredit() + 10);
		//userDao.update(user);
	}
	
	public void removeTopic(int topicId) {
		Topic topic = topicDao.get(topicId);
		
		Board board = topic.getBoard();
		board.setTopicNum(board.getTopicNum() - 1);
		//boardDao.update(board);
		
		User user = topic.getUser();
		user.setCredit(user.getCredit() - 50);
		//userDao.update(user);
		
		topicDao.remove(topic);
		postDao.deleteTopicPosts(topicId);
	}
	
	public void addPost(Post post) {
		postDao.save(post);
		User user = post.getUser();
		user.setCredit(user.getCredit() + 5);
		userDao.update(user);
		Topic topic = post.getTopic();
		topic.setTopicReplies(topic.getTopicReplies() + 1);
		topic.setLastPost(new Date());
	}
	
	public void addBoard(Board board) {
		boardDao.save(board);
	}
	
	public Board getBoardById(int boardId) {
		return boardDao.get(boardId);
	}
	
	public List<Board> getAllBoards(){
		return boardDao.loadAll();
	}
	
	public Page getPagedTopics(int boardId, int pageNo, int pageSize) {
		return topicDao.getPagedTopics(boardId, pageNo, pageSize);
	}

	public Topic getTopicByTopicid(Integer topicId) {
		return topicDao.get(topicId);
	}

	public Page getPagedPosts(Integer topicId, Integer pageNo, int pageSize) {
		return postDao.getPagedPosts(topicId, pageNo, pageSize);
	}
	
}