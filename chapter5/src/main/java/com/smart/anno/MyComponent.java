package com.smart.anno;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class MyComponent{
	
	@Autowired(required=false)
	private List<Plugin> plugins;
	
	@Autowired
	private Map<String,Plugin> pluginMaps;
	
	public List<Plugin> getPlugins(){
		return this.plugins;
	}
}