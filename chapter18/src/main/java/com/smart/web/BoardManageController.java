package com.smart.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.smart.cons.CommonConstant;
import com.smart.dao.Page;
import com.smart.domain.Board;
import com.smart.domain.Topic;
import com.smart.domain.User;
import com.smart.service.ForumService;

@Controller
public class BoardManageController extends BaseController{
	@Autowired
	private ForumService forumService;
	
	@RequestMapping(value = "/board/listBoardTopics-{boardId}", method = RequestMethod.GET)
	public ModelAndView listBoardTopics(@PathVariable Integer boardId, 
			@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		ModelAndView mav = new ModelAndView();
		Board board = forumService.getBoardById(boardId);
		pageNo = pageNo == null?1:pageNo;
		Page pagedTopic = forumService.getPagedTopics(boardId, pageNo, CommonConstant.PAGE_SIZE);
		mav.addObject("board", board);
		mav.addObject("pagedTopic", pagedTopic);
		mav.setViewName("/listBoardTopics");
		return mav;
	}
	@RequestMapping(value="/board/addTopicPage-{boardId}", method = RequestMethod.GET)
	public ModelAndView addTopicPage(@PathVariable Integer boardId) {
		ModelAndView view = new ModelAndView();
		view.addObject("boardId", boardId);
		view.setViewName("/addTopic");
		return view;
	}
	
	@RequestMapping(value = "/board/addTopic", method = RequestMethod.POST)
	public String addTopic(HttpServletRequest request, Topic topic) {
		User user = getSessionUser(request);
		topic.setUser(user);
		Date now = new Date();
		topic.setCreateName(now);
		topic.setLastPost(now);
		forumService.addTopic(topic);
		String targetUrl = "/board/listBoardTopics-" + topic.getBoard().getBoardId() + ".html";
		return "redirect:" + targetUrl; 
	}
	
	@RequestMapping(value = "/board/listTopicPosts-{topicId}", method = RequestMethod.GET)
	public ModelAndView listTopicPosts(@PathVariable Integer topicId, 
			@RequestParam(value = "pageNo", required = false) Integer pageNo) {
		ModelAndView view = new ModelAndView();
		Topic topic = forumService.getTopicByTopicid(topicId);
		pageNo = pageNo == null?1:pageNo;
		Page pagedPost = forumService.getPagedPosts(topicId, pageNo, CommonConstant.PAGE_SIZE);
		view.addObject("topic", topic);
		view.addObject("pagedPost", pagedPost);
		view.setViewName("/listTopicPosts");
		return view;
	}
	
	
}