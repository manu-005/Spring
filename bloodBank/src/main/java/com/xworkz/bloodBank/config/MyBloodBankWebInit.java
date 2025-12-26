package com.xworkz.bloodBank.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyBloodBankWebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    public MyBloodBankWebInit()
    {
        System.out.println("web init object created.");
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{MyBloodBankConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }
}
