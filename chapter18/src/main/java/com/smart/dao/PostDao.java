package com.smart.dao;

import org.springframework.stereotype.Repository;

import com.smart.domain.Post;

@Repository
public class PostDao extends BaseDao<Post>{
	private static final String GET_PAGED_POSTS = "from Post where topic.topicId = ? order by createTime desc";
	private static final String DELETE_TOPIC_POSTS = "delete from Post where topic.topicId = ?";

	public Page getPagedPosts(int topicId, int pageNo, int pageSize) {
		return pagedQuery(GET_PAGED_POSTS, pageNo, pageSize, topicId);
	}
	
	public void deleteTopicPosts(int topicId) {
		//这里使用bulkupdata是因为它可以带上参数
		getHibernateTemplate().bulkUpdate(DELETE_TOPIC_POSTS, topicId);
	}
}
