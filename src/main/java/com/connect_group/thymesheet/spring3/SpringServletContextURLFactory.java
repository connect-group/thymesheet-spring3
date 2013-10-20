package com.connect_group.thymesheet.spring3;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;

import com.connect_group.thymesheet.ServletContextURLFactory;

public class SpringServletContextURLFactory implements ServletContextURLFactory {

	private ServletContext servletContext;
	
	public SpringServletContextURLFactory() {
		super();
	}
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	public URL getURL(String filePath) throws MalformedURLException {
		return servletContext.getResource(filePath);
	}

}
