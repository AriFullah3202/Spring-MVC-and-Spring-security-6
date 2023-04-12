package com.test001.web_config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com")
@EnableTransactionManagement
public class WebConfig implements WebMvcConfigurer {
	
	
	
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setSuffix(".jsp");
		resolver.setPrefix("/WEB-INF/view/");
		return resolver;
	}
	
	
@Bean
	
	 public DataSource dataSource() {

		  DriverManagerDataSource dataSource = new DriverManagerDataSource();
		  dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		  dataSource.setUrl("jdbc:mysql://localhost:3306/customer");
		  dataSource.setUsername("root"); 
		  dataSource.setPassword("root"); 		  
		  
		  return dataSource;		 
		 
	 }
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean session = new LocalSessionFactoryBean();
		session.setDataSource(dataSource());
	    session.setPackagesToScan("com.test001.entity");
	    session.setHibernateProperties(hibernateProperties());
	    
	    
		return  session;	
		
	}
	
	 private Properties hibernateProperties() {
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	        hibernateProperties.setProperty("hibernate.show_sql", "true");
	        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
	        return hibernateProperties;
	    }
	
	    @Bean
	    public HibernateTransactionManager transactionManager(SessionFactory session) {
	    	
	    	HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(session);
	    			
	    	return hibernateTransactionManager;
	 
	
	    }
	  
	    
	
	
	
	
	
	
	
}
