package com.smart.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_topic")
public class Topic extends BaseDomain{
	
	private static final int DIGEST_TOPIC = 1;
	
	private static final int NOT_DIGEST_TOPIC = 0;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "topic_id")
	private int topicId;
	
	@Column(name = "topic_title")
	private String topicTitle;
	
	@Column(name = "create_name")
	private Date createName;
	
	@Column(name = "last_post")
	private Date lastPost;
	
	@Column(name = "topic_view")
	private int topicView;
	
	@Column(name = "topic_replies")
	private int topicReplies;
	
	@Column(name = "digest")
	private int digest = NOT_DIGEST_TOPIC;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name = "board_id")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public Date getCreateName() {
		return createName;
	}

	public void setCreateName(Date createName) {
		this.createName = createName;
	}

	public Date getLastPost() {
		return lastPost;
	}

	public void setLastPost(Date lastPost) {
		this.lastPost = lastPost;
	}

	public int getTopicView() {
		return topicView;
	}

	public void setTopicView(int topicView) {
		this.topicView = topicView;
	}

	public int getTopicReplies() {
		return topicReplies;
	}

	public void setTopicReplies(int topicReplies) {
		this.topicReplies = topicReplies;
	}

	public int getDigest() {
		return digest;
	}

	public void setDigest(int digest) {
		this.digest = digest;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}