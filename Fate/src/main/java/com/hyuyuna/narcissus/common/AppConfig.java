package com.hyuyuna.narcissus.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class AppConfig {
	
	@Value("${globals.imagesDir}")
	private String imagesDir;
	static String imageDir;

	
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() {
		PropertySourcesPlaceholderConfigurer config = new PropertySourcesPlaceholderConfigurer();
		Resource location = new ClassPathResource("config/globals.properties");
		config.setLocation(location);
		return config;
	}
	
	@Bean
	public AdminConnection adminConnection() {
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setImagesDir(imagesDir);
		imageDir = imagesDir;
		System.out.println(imagesDir);
		return adminConnection;
	}
	
	public static String getImageDir() {
		return imageDir;
	}

}
