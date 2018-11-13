package com.smart.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MailSender implements ApplicationContextAware{
	private ApplicationContext ctx;
	//ApplicationContextAware的接口方法，以便容器启动时注入容器实例
	public void setApplicationContext(ApplicationContext ctx)
		throws BeansException{
		this.ctx = ctx;
	}
	
	public void sendMail(String to) {
		System.out.println("MAIL sender:模拟发送邮件");
		MailSendEvent mse = new MailSendEvent(this.ctx, to);
		ctx.publishEvent(mse);
	}
}