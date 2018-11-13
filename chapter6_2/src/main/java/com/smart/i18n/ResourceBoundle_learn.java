package com.smart.i18n;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBoundle_learn{
	public static void main(String args[]) {
		ResourceBundle rb1 = ResourceBundle.getBundle("com/smart/i18n/resource",Locale.US);
		ResourceBundle rb2 = ResourceBundle.getBundle("com/smart/i18n/resource",Locale.CHINA);
		System.out.println("us:" + rb1.getString("greeting.comon"));
		System.out.println("cn:" + rb2.getString("greeting.common"));
	
	
		ResourceBundle rb3 = ResourceBundle.getBundle("com/smart/i18n/fmt_resource",Locale.US);
		ResourceBundle rb4 = ResourceBundle.getBundle("com/smart/i18n/fmt_resource",Locale.CHINA);
		Object [] params = {"John", new GregorianCalendar().getTime()};
		
		String str1 = new MessageFormat(rb3.getString("greeting.common"),Locale.US).format(params);
		System.out.println(str1);
		String str2 = new MessageFormat(rb4.getString("greeting.morning"),Locale.CHINA).format(params);
		String str3 = new MessageFormat(rb4.getString("greeting.afternoon"),Locale.CHINA).format(params);
		
		System.out.println(str2);
		System.out.println(str3);
		
	}
}