package com.smart.web;

import static com.smart.cons.CommonConstant.*;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smart.domain.User;
import com.smart.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	  
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//用户登陆
	@RequestMapping("/doLogin")
	public ModelAndView login(HttpServletRequest request, User user) {
		User dbUser = userService.getUserByUserName(user.getUserName());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/login.jsp");
		if(dbUser == null) {
			mav.addObject("errorMsg", "用户名不存在");
		}else if(!dbUser.getPassword().equals(user.getPassword())) {
			mav.addObject("errorMsg", "用户密码不正确");
		}else if(dbUser.getLocked() == User.USER_LOCK) {
			mav.addObject("errorMsg", "用户已被锁定，不能登陆");
		}else {
			dbUser.setLastIp(request.getRemoteAddr());
			dbUser.setLastVisit(new Date());
			userService.loginSuccess(dbUser);
			setSessionUser(request, dbUser);
			String toUrl = (String)request.getSession().getAttribute(LOGIN_TO_URL);
			request.getSession().removeAttribute(LOGIN_TO_URL);
			
			if(StringUtils.isEmpty(toUrl)) {
				toUrl = "/index.html";
			}
			mav.setViewName("redirect:" + toUrl);
		}
		return mav;
	}
	
	@RequestMapping("/doLogout")
	public String logout(HttpSession session) {
		session.removeAttribute(USER_CONTEXT);
		return "forward:/index.jsp";
	}
}