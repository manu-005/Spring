package com.xworkz.xworkzModel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.xworkz.xworkzModel")
public class ModelConfig {
    public ModelConfig() {
        System.out.println("config object...");
    }

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver view = new InternalResourceViewResolver();

        view.setPrefix("/");
        view.setSuffix(".jsp");

        return view;
    }

    @Bean
    public DataSource getDBProperties() {

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/library");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("tiger");

        return driverManagerDataSource;
    }

    public Properties getproperties() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto","update");

        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){

        LocalContainerEntityManagerFactoryBean beanFactory = new LocalContainerEntityManagerFactoryBean();

        beanFactory.setDataSource(getDBProperties());
        beanFactory.setPackagesToScan("com.xworkz.xworkzModel.entity");

        beanFactory.setJpaProperties(getproperties());

        beanFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return beanFactory;
    }
}
