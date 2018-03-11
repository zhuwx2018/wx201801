package com.wx.config.system;

import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

@Configuration
public class SystemConfig {
	@Bean
	public VelocityEngineFactoryBean velocityEngine(){
		VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();
		Properties prop = new Properties();
		prop.setProperty("resource.loader", "class");
		prop.setProperty("class.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.setVelocityProperties(prop);
		return velocityEngine;
	}
}
