package com.smart.web;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.smart.domain.User;
import com.smart.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController{
	@RequestMapping("/register")
	public String register() {
		return "user/register";
	}
	@Autowired
	private UserService userService;
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("user")User user) {
		userService.createUser(user);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/createSuccess");
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping("/detail/{userId}")
	public ModelAndView showDetail(@PathVariable("userId") String userId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/showDetail");
		mav.addObject("user", userService.getUserById(userId));
		return mav;
	}
	
	@RequestMapping(path="/delete", method=RequestMethod.POST, params="userId")
	public ModelAndView test1(@RequestParam("userId") String userId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/deleteSuccess");
		mav.addObject("userId", userId);
		return mav;
	}
	
	@RequestMapping(path="/delete", method=RequestMethod.GET)
	public String test2() {
		return "user/delete";
	}
	
	@RequestMapping(path="/handle31")
	public void handle31(OutputStream os) throws IOException{
		Resource res = new ClassPathResource("/image.jpg");
		FileCopyUtils.copy(res.getInputStream(), os);
	}
	
	@RequestMapping(path = "/handle41")
	public String handle41(@RequestBody String requestBody) {
		System.out.println(requestBody);
		return "success";
	}
	@ResponseBody
	@RequestMapping(path = "handle42/{imageId}")
	public byte[] handle42(@PathVariable("imageId") String imageId) throws IOException{
		System.out.println("load image of " + imageId);
		Resource res = new ClassPathResource("/image.jpg");
		byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
		return fileData;
	}
	
	@RequestMapping(path = "/handle43")
	public String handle43(HttpEntity<String> httpEntity) {
		long contentLen = httpEntity.getHeaders().getContentLength();
		System.out.println(httpEntity.getBody());
		return "success";
	}
	
	@RequestMapping(path = "/handle44/{imageId}")
	public ResponseEntity<byte[]> handle44(@PathVariable("imageId") String imageId)throws Throwable{
		Resource res = new ClassPathResource("/image.jpg");
		byte[] fileData = FileCopyUtils.copyToByteArray(res.getInputStream());
		ResponseEntity<byte[]> responseEntity = 
				new ResponseEntity<byte[]>(fileData, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(path = "/handle51")
	public ResponseEntity<User> handle51(HttpEntity<User> requestEntity){
		User user = requestEntity.getBody();
		user.setUserId("1000");
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}