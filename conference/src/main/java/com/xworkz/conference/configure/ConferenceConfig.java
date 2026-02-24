package com.xworkz.conference.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

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

    @Bean
    public DataSource getDBProperties() {

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/conference");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("tiger");

        return driverManagerDataSource;
    }

    public Properties getproperties() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");

        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

        LocalContainerEntityManagerFactoryBean localEntity = new LocalContainerEntityManagerFactoryBean();

        localEntity.setDataSource(getDBProperties());
        localEntity.setPackagesToScan("com.xworkz.conference.entity");
        localEntity.setJpaProperties(getproperties());
        localEntity.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return localEntity;
    }
}
