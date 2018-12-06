package com.smart.web;

import java.io.IOException;
import java.util.Collections;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import com.smart.domain.User;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import junit.framework.Assert;

public class UserControllerTest{
	//@Test
	public void testHandle41() {
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("userName", "Tom");
		form.add("password", "123456");
		form.add("age", "45");
		restTemplate.postForLocation("http://localhost:8097/bbs/user/handle41.html", form);
	}
	
	//@Test
	public void testHandle42() throws IOException{
		RestTemplate restTemplate = new RestTemplate();
		byte [] response = restTemplate.postForObject("http://localhost:8097/bbs/user/handle42/{itemId}.html",
				null, byte[].class, "1233");
		Resource outFile = new FileSystemResource("d:/image_copy.jpg");
		FileCopyUtils.copy(response, outFile.getFile());
	}
	
	private RestTemplate buildRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		XStreamMarshaller xmlMarshaller = new XStreamMarshaller();
		xmlMarshaller.setStreamDriver(new StaxDriver());
		xmlMarshaller.setAnnotatedClasses(new Class[] {User.class});
		MarshallingHttpMessageConverter xmlConverter = 
				new MarshallingHttpMessageConverter();
		xmlConverter.setMarshaller(xmlMarshaller);
		xmlConverter.setUnmarshaller(xmlMarshaller);
		restTemplate.getMessageConverters().add(xmlConverter);
		MappingJackson2HttpMessageConverter jsonConverter = 
				new MappingJackson2HttpMessageConverter();
		restTemplate.getMessageConverters().add(jsonConverter);
		return restTemplate;
	}
	//@Test
	public void testHandle51() throws IOException{
		RestTemplate restTemplate = buildRestTemplate();
		User user = new User();
		user.setUserName("tom");
		user.setPassword("12345");
		user.setRealName("汤姆");
		HttpHeaders entityHeaders = new HttpHeaders();
        entityHeaders.setContentType(MediaType.valueOf("application/json;UTF-8"));
        entityHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<User> requestEntity = new HttpEntity<User>(user, entityHeaders);


        ResponseEntity<User> responseEntity = restTemplate.exchange(
                "http://localhost:8097/bbs/user/handle51.html",
                HttpMethod.POST, requestEntity, User.class);
		User responseUser = responseEntity.getBody();
		Assert.assertNotNull(responseUser);
		Assert.assertEquals("1000", responseUser.getUserId());
		Assert.assertEquals("tom", responseUser.getUserName());
		Assert.assertEquals("汤姆", responseUser.getRealName());
	}
	
	//@Test
	public void testHandle82() {
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String,String>form = new LinkedMultiValueMap<String,String>();
		form.add("userName", "tom");
		form.add("password", "123456");
		form.add("age", "45");
		form.add("birthday", "1980-01-01");
		form.add("salary", "4,500.00");
		String html = restTemplate.postForObject("http://localhost:8097/bbs/user/handle82.html", 
				form, String.class);
		Assert.assertNotNull(html);
		Assert.assertTrue(html.indexOf("tom")>-1);
	}
}