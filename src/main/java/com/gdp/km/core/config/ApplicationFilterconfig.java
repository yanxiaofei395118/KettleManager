package com.gdp.km.core.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdp.km.core.filter.CrossOriginFilter;

/**
 * 创建cors过滤器
 * */
@Configuration
public class ApplicationFilterconfig {
	
	/**
	 * @see setFilter 设置该过滤器类方法
	 * @see setName 设置该过滤器名称
	 * @see addUrlPatterns 设置该过滤器过滤的url
	 * @see setOrder 设置该过滤器的执行顺序
	 */
	@Bean
	public FilterRegistrationBean MyFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new CrossOriginFilter());
		registration.setName("CrossOriginFilter");
		registration.addUrlPatterns("/*");	
		registration.setOrder(-Integer.MAX_VALUE);
		return registration;
	}

}
