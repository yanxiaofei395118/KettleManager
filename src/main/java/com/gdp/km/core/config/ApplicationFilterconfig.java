package com.gdp.km.core.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdp.km.core.filter.CrossOriginFilter;

@Configuration
public class ApplicationFilterconfig {
	
	/**
	 * 创建cors过滤器
	 */
	@Bean
	public FilterRegistrationBean MyFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new CrossOriginFilter());
		registration.addUrlPatterns("/*");
		registration.setName("CrossOriginFilter");
		registration.setOrder(-Integer.MAX_VALUE);
		return registration;
	}

}
