package com.smart.i18n;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author DEll
 *
 */
public class Local_learn{
	public static void main(String args[]) {
		//1带有语言和国家/地区信息的本地化对象
		Locale locale1 = new Locale("zh","CN");
		//2只有语言信息的本地化对象
		Locale locale2 = new Locale("zh");
		//3等同于1(静态常量的方式)
		Locale locale3 = Locale.CHINA;
		//4等同于2
		Locale locale4 = Locale.CHINESE;
		//获取本地系统默认的本地化对象
		Locale locale5 = Locale.getDefault();
		
		NumberFormat currFmt = NumberFormat.getCurrencyInstance(locale1);
		double amt = 123456.78;
		System.out.println(currFmt.format(amt));
		Date date = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale1);
		System.out.println(df.format(date));
		
		
		//格式化信息串
		String pattern1 = "{0},您好,您于{1}在工商银行存入{2}元";
		String pattern2 = "At {1,time,short} On {1,date,long},{0}paid{2,number,currency}.";
		//用于动态替换占位符的参数
		Object[] params = {"John", new GregorianCalendar().getTime(), 1.0E3};
		//使用默认的本地化对象格式化信息
		String msg1 = MessageFormat.format(pattern1, params);
		System.out.println(msg1);
		//使用指定的本地化对象格式化信息
		MessageFormat mf = new MessageFormat(pattern2,Locale.US);
		String msg2 = mf.format(params);
		
		System.out.println(msg2);
	
	}
}