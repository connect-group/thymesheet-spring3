package com.connect_group.thymesheet.spring3;

import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.templatemode.ITemplateModeHandler;

import com.connect_group.thymesheet.templatemode.IThymesheetTemplateModeHandler;
import com.connect_group.thymesheet.templatemode.ThymesheetStandardTemplateModeHandlers;

public class SpringThymesheetTemplateEngine extends SpringTemplateEngine implements ServletContextAware {

	private SpringServletContextURLFactory urlFactory;
	
	public SpringThymesheetTemplateEngine() {
		super();
		urlFactory = new SpringServletContextURLFactory();
		initialiseTemplateModeHandlers(ThymesheetStandardTemplateModeHandlers.ALL_TEMPLATE_MODE_HANDLERS);
		setDefaultTemplateModeHandlers(ThymesheetStandardTemplateModeHandlers.ALL_TEMPLATE_MODE_HANDLERS);
	}
	
	public void setServletContext(ServletContext servletContext) {
		urlFactory.setServletContext(servletContext);
	}
	
	@Override
	public void setTemplateModeHandlers(Set<? extends ITemplateModeHandler> templateModeHandlers) {
		initialiseTemplateModeHandlers(templateModeHandlers);
		super.setTemplateModeHandlers(templateModeHandlers);
	}

	@Override
	public void addTemplateModeHandler(ITemplateModeHandler templateModeHandler) {
		initialiseTemplateModeHandler(templateModeHandler);
		super.addTemplateModeHandler(templateModeHandler);
	}

	private void initialiseTemplateModeHandlers(Set<? extends ITemplateModeHandler> handlers) {
		for(ITemplateModeHandler handler : handlers) {
			initialiseTemplateModeHandler(handler);
		}		
	}
	
	private void initialiseTemplateModeHandler(ITemplateModeHandler handler) {
		if(handler instanceof IThymesheetTemplateModeHandler && ((IThymesheetTemplateModeHandler) handler).getUrlFactory()==null) {
			((IThymesheetTemplateModeHandler) handler).setUrlFactory(urlFactory);
		}
	}

}
