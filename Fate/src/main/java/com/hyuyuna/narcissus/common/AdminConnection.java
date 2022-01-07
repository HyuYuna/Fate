package com.hyuyuna.narcissus.common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean{
	private Environment env;
	private String imagesDir;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("필드 세팅");
		setImagesDir(env.getProperty("imagesDir"));
	}
	
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("환경 설정");
		setEnv(environment);
	}
	
	public void setEnv(Environment ev) {
		this.env = ev;
	}

	public String getImagesDir() {
		return imagesDir;
	}

	public void setImagesDir(String imagesDir) {
		this.imagesDir = imagesDir;
	}
	
}
