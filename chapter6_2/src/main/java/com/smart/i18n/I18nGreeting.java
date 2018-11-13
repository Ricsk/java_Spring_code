package com.smart.i18n;

import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class I18nGreeting{
	public static void ResourceBundleMessageSOurce() {
		String [] configs = {"com/smart/i18n/beans.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
	
		MessageSource ms = (MessageSource)ctx.getBean("myResource");
		Object [] params = {"John", new GregorianCalendar().getTime()};
		
		String str1 = ms.getMessage("greeting.common", params, Locale.US);
		String str2 = ms.getMessage("greeting.morning", params, Locale.CHINA);
		String str3 = ms.getMessage("greeting.afternoon", params, Locale.CHINA);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
	}
	public static void ReloadableResourceBundleMessageSOurce() {
		String [] configs = {"com/smart/i18n/beans.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
		
		MessageSource ms = (MessageSource)ctx.getBean("myResource2");
		Object [] params = {"John", new GregorianCalendar().getTime()};
		
		for(int i = 0; i < 2; i++) {
			String str1 = ms.getMessage("greeting.common", params, Locale.US);
			System.out.println(str1);
			try {
				Thread.currentThread().sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void MessageSOurce() {
		String [] configs = {"com/smart/i18n/beans.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
		
		Object [] params = {"John", new GregorianCalendar().getTime()};
		
		String str1 = ctx.getMessage("greeting.common", params, Locale.US);
		String str2 = ctx.getMessage("greeting.common", params, Locale.CHINA);
		System.out.println(str1);
		System.out.println(str2);
		
	}
	public static void main(String args[]) {
		//ResourceBundleMessageSOurce();
		//ReloadableResourceBundleMessageSOurce();
		 MessageSOurce();
	}
}