package com.smart.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class PatternResolverTest{
	@Test
	public void getResources() throws Throwable{
		ResourcePatternResolver resolver = 
				new PathMatchingResourcePatternResolver();
		
	
	
	Resource resources[] = resolver.getResources("classpath*:com/smart/**/*.xml");
	assertNotNull(resources);
	for(Resource resource:resources) {
		System.out.println(resource.getDescription());
	}
}
}