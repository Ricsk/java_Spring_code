package com.smart.dao;

import org.springframework.stereotype.Repository;

import com.smart.domain.Topic;

@Repository
public class TopicDao extends BaseDao<Topic>{
	private static final String GET_BOARD_DIGEST_TOPICS = "from Topic t where t.boardId = ? "
			+" and digest > 0 order by t.lastPost desc, digest desc";
	private static final String GET_PAGE_TOPICS = "from Topic where boardId = ? "
			+ " order by lastPost desc";
	private static final String QUERY_TOPIC_BY_TITLE = "from Topic where topicTitle like ? "
			+" order by lastPost desc";
	
	//获取某一版块的精华帖子，按最后登时间和精华级别排序
	public Page getBoardDigestTopics(int boardId, int pageNo, int pageSize) {
		return pagedQuery(GET_BOARD_DIGEST_TOPICS, pageNo, pageSize, boardId);
	}
	//获取某一版块的帖子
	public Page getPagedTopics(int boardId, int pageNo, int pageSize) {
		return pagedQuery(GET_PAGE_TOPICS, pageNo, pageSize, boardId);
	}
	
	public Page queryTopicByTitle(String title, int pageNo, int pageSize) {
		return pagedQuery(QUERY_TOPIC_BY_TITLE, pageNo, pageSize, "%" + title + "%" );
	}
}