package com.gdp.km.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrossOriginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
			
		httpResponse.setContentType("text/html;charset=UTF-8");
		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE");
		httpResponse.setHeader("Access-Control-Max-Age", "0");
		httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,Authorization");
		httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
		httpResponse.setHeader("XDomainRequestAllowed","1");
        
		String cs=httpRequest.getHeader("Authorization");
		if(httpRequest.getMethod().equals("OPTIONS")){
			httpResponse.setStatus(HttpServletResponse.SC_OK);
		}else{
			chain.doFilter(request, response);
		}
        

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
