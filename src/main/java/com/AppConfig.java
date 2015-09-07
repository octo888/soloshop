package com;

import com.core.beans.Cart;
import com.core.entity.Book;
import com.core.mail.GMailAuthenticator;
import com.core.mail.MailMail;
import org.springframework.context.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.mail.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Configuration
@ComponentScan
@EnableWebMvc
@Import({SpringDataConfig.class, ViewConfig.class, SecurityConfig.class})
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        return resolver;
    }

    @Bean
    public JavaMailSender mailSender(){
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setProtocol("smtp");
        sender.setHost("smtp.gmail.com");
        sender.setPort(587);
        sender.setUsername("vvmoroz88@gmail.com");
        sender.setPassword("octo888fcdk1488");


        Properties mailProps = new Properties();
        mailProps.put("mail.smtps.auth", "true");
        mailProps.put("mail.smtp.starttls.enable", "true");
        mailProps.put("mail.smtp.debug", "true");
        mailProps.put("mail.smtp.debug", "true");



        //Session session = Session.getInstance(mailProps, new GMailAuthenticator("solobook88@gmail.com", "dynamo1488"));
        sender.setJavaMailProperties(mailProps);

        return sender;
    }



}
