package com.smart.placeholder;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

//继承PropertyPlaceholderConfigurer定义支持密文版属性的属性配置器
public class EncryptPropertyPlaceholderConfigurer extends
PropertyPlaceholderConfigurer{
	private String[] encryptPropNames = {"userName","password"};
	
	//对特定属性进行转换
	@Override
	protected String convertProperty(String propertyName, String propertyValue){
		if(isEncryptProp(propertyName)) {
			String decryptValue = DESUtils.getDecryptString(propertyValue);
			System.out.println(decryptValue);
			return decryptValue;
		}else {
			return propertyValue;
		}
	}
	
	//判断是否是需要解密的属性
	private boolean isEncryptProp(String propertyName) {
		for(String encryptPropName:encryptPropNames) {
			if(encryptPropName.equals(propertyName)) {
				return true;
			}
		}
		return false;
	}
}