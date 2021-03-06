package com.smart.aspectJ.anno;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.smart.aspectJ.anno.ForumService;

public class ToolTest{
	//@Test
	public void tool() {
		//得到ForumService对应的Class对象
		Class clazz = ForumService.class;
		
		//得到ForumService对应的Method数组
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println(methods.length);
		for(Method method : methods) {
			
			//获取标注对象
			NeedTest nt = method.getAnnotation(NeedTest.class);
			if(nt != null) {
				if(nt.value()) {
					System.out.println(method.getName() + "{}需要测试");
				}else {
					System.out.println(method.getName() + "{}不需要测测试");
				}
			}
		}
	}
}