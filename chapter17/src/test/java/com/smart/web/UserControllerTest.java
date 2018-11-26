package com.smart.web;

import java.io.IOException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

public class UserControllerTest{
	@Test
	public void testHandle41() {
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("userName", "Tom");
		form.add("password", "123456");
		form.add("age", "45");
		restTemplate.postForLocation("http://localhost:8097/bbs/user/handle41.html", form);
	}
	
	@Test
	public void testHandle42() throws IOException{
		RestTemplate restTemplate = new RestTemplate();
		byte [] response = restTemplate.postForObject("http://localhost:8097/bbs/user/handle42/{itemId}.html",
				null, byte[].class, "1233");
		Resource outFile = new FileSystemResource("d:/image_copy.jpg");
		FileCopyUtils.copy(response, outFile.getFile());
	}
}