package com.employee.configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class Web extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { EmployeeServlet.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
