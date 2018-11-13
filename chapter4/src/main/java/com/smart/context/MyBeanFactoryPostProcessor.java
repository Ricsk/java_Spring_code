package com.smart.context;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import com.smart.Car;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{
	//对car的brand配置信息进行加工操作
	public void postProcessBeanFactory(ConfigurableListableBeanFactory bf)
		throws BeansException{
		BeanDefinition bd = bf.getBeanDefinition("car1");
		bd.getPropertyValues().addPropertyValue("brand", "奇瑞QQ");
		System.out.println("调用BeanFactoryPostProcessor.postProcessBean Factory()");
		
	}
}