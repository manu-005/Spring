package com.xworkz.bloodBank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.xworkz.bloodBank")
public class MyBloodBankConfig {

    public MyBloodBankConfig() {
        System.out.println("my blood bank config object created");
    }

    @Bean
    public DataSource getDataSource() {

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/library");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("tiger");
      return driverManagerDataSource;
    }

    public Properties getProperties(){

        Properties properties = new Properties();

        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
        properties.setProperty("hibernate.show_sql","true");

        return  properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(){

        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(getDataSource());
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.xworkz.bloodBank.entity");
        localContainerEntityManagerFactoryBean.setJpaProperties(getProperties());

        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        return localContainerEntityManagerFactoryBean;

    }


}
