package com.xworkz.conference.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.xworkz.conference")
public class ConferenceConfig implements WebMvcConfigurer {

    public ConferenceConfig() {
        System.out.println("conference config object created..");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {

        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxInMemorySize(50 * 1024 * 1024); // 50 mb
        resolver.setMaxUploadSize(80 * 1024 * 1024); // 80 mb

        return resolver;
    }

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();

        internalResourceViewResolver.setPrefix("/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
}
