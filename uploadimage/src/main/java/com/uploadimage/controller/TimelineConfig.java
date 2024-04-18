//package com.uploadimage.controller;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//public class TimelineConfig {
//	
//	    @Autowired
//	    private EntityManagerFactory entityManagerFactory;
//
//	    @Bean
//	    public PlatformTransactionManager transactionManager() {
//	        return new JpaTransactionManager(entityManagerFactory);
//	    }
//	}
//
//
//    
//
