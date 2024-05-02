package com.dominio.Seguridad3.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MiServletSpringInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}
//indicamos donde se encuentra la configuración
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[]{App.class};
	}
//mapeo del servlet
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String []{"/"};
	}

}
