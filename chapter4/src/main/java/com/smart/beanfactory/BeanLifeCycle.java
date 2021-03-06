package com.smart.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.smart.Car;
public class BeanLifeCycle{
	private static void LifeCycleInBeanFactory() {
		//装载配置文件并启动容器
		Resource res = new ClassPathResource("com/smart/beanfactory/beans.xml");
		BeanFactory bf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory)bf);
		reader.loadBeanDefinitions(res);
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/beanfactory/beans.xml");
		//向容器注册MyBeanPostProcessor后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
		//ctx.addBeanPostProcessor(new MyBeanPostProcessor());
		//向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		
		//第一次从容器中获取car，将出发容器实例化Bean,将引发生命周期方法的调用
		Car car1 = (Car)bf.getBean("car1");
		car1.introduce();
		car1.setColor("红色");
		
		//第二次从容器中获取Car，直接从缓存池中获取
		Car car2 = (Car)bf.getBean("car1");
		
		//查看car1和car2是否指向同一引用
		System.out.println("car1 == car2:" + (car1==car2));
		
		//关闭容器
		((DefaultListableBeanFactory)bf).destroySingletons();
	}
	
	public static void main(String[] args) {
		LifeCycleInBeanFactory();
	}
}