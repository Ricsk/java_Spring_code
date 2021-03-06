package com.smart.web;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.smart.domain.User;
import com.smart.domain.UserEditor;
import com.smart.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
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
	
	@RequestMapping(path = "/handle61")
	public String handle61(@ModelAttribute("user") User user) {
		user.setUserId("1000");
		return "/user/createSuccess";
	}
	@ModelAttribute("user")
	public User getUser() {
		User user = new User();
		user.setUserId("1001");
		user.setUserName("sss");
		return user;
	}
	@RequestMapping(path = "/handle62")
	public String handle62(@ModelAttribute("user") User user) {
		user.setUserName("tom");
		return "/user/showDetail";
	}
	
	@RequestMapping(path = "/handle63")
	//public String handle63(ModelMap modelMap, @RequestParam("userName") String name) {
	public String handle63(ModelMap modelMap) {
		modelMap.addAttribute("testAttr", "value1");
		User user = (User)modelMap.get("user");
		//user.setUserName(name);
		return "/user/showDetail";
	}
	
	@RequestMapping(path = "/handle71")
	public String handle71(@ModelAttribute("user") User user) {
		user.setUserName("John");
		return "redirect:/user/handle72.html";
	}
	@RequestMapping(path = "/handle72")
	public String handle72(ModelMap modelMap, SessionStatus sessionStatus) {
		User user = (User)modelMap.get("user");
		if(user != null) {
			user.setUserName("Jetty");
			//sessionStatus.setComplete();
		}
		return "/user/showDetail";
	}
	
	@RequestMapping(path = "/handle81")
	public String handle81(@RequestParam("user") User user, ModelMap modelMap) {
		modelMap.put("user", user);
		return "/user/showDetail";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(User.class, new UserEditor());
	}
	
	@RequestMapping(path="/handle82") 
	public String handle82(User user) {
		return "/user/showDetail";
	}
	
	@RequestMapping(path="/handle91")
	public String handle91(@Valid @ModelAttribute("user") User uer, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/user/register_back";
		}else {
			return "/user/showDetail";
		}
	}
	@RequestMapping(path="/handle92")
	public String handle92(@ModelAttribute("user")User user, BindingResult bindingResult) {
		ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "userName", "required");
		if("aaaa".equalsIgnoreCase(user.getUserName())) {
			bindingResult.rejectValue("userName", "reserved");
		}
		if(bindingResult.hasErrors()) {
			return "/user/register4";
		}else
			return "/user/showDetail";
	}
	
	@RequestMapping(path = "/showUserList")
	public String showUserList(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		List<User>userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆");
		calendar.set(1980, 1,1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "user/userList";
	}
	
	@RequestMapping(path = "/showUserListByFtl")
	public String ShowUserListInFtl(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		List<User>userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆");
		calendar.set(1980, 1,1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "userListFtl";
	}
	
	@RequestMapping(path = "/showUserListByXis")
	public String ShowUserListInExcel(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		List<User>userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆");
		calendar.set(1980, 1,1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "userListExcel";
	}
	
	@RequestMapping(path = "/showUserListByXml")
	public String showUserListInXml(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		List<User>userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆");
		calendar.set(1980, 1,1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "userListXml";
	}
	
	@RequestMapping(path = "/showUserListByJson")
	public String showUserListInJson(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		List<User>userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆");
		calendar.set(1980, 1,1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "userListJson";
	}
	
	@RequestMapping(path = "/showUserListMix")
	public String showUserListMix(ModelMap mm) {
		Calendar calendar = new GregorianCalendar();
		List<User>userList = new ArrayList<User>();
		User user1 = new User();
		user1.setUserName("tom");
		user1.setRealName("汤姆");
		calendar.set(1980, 1,1);
		user1.setBirthday(calendar.getTime());
		User user2 = new User();
		user2.setUserName("john");
		user2.setRealName("约翰");
		user2.setBirthday(calendar.getTime());
		userList.add(user1);
		userList.add(user2);
		mm.addAttribute("userList", userList);
		return "userListMix";
	}
	
	@RequestMapping(path = "/uploadPage")
	public String updatePage() {
		return "uploadPage";
		//retrun "redirect:uploadPage.html";
	}
	@RequestMapping(path = "/success")
	public String Success() {
		return "success";
	}
	@RequestMapping(path = "/upload")
	public String updateThumb(@RequestParam("name") String name, 
			@RequestParam("file") MultipartFile file) throws Exception{
		if(!file.isEmpty()) {
			file.transferTo(new File("e:/temp/" + file.getOriginalFilename()));
			return "redirect:success.html";
		}else {
			return "redirect:fail.html";
		}
	}
/*	@RequestMapping(path = "/hello")
	public String hello() {
		return "hello";
	}*/
	
}

@Controller
class OtherTest{
	@RequestMapping(path="/hello")
	public String websocketTest() {
		return "hello";
	}
	@RequestMapping(path="/test")
	public String resTest() {
		return "test";
	}
}