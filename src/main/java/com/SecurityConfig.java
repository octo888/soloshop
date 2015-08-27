package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


    @Autowired
    protected void configureAuth(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder())
                .authoritiesByUsernameQuery("select app_user.name, role.name from app_user\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t   join app_user_Role on app_user.id = app_user_Role.users_id\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t   join role on app_user_Role.roles_id = role.id\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t   where app_user.name = ?")
                .usersByUsernameQuery("select name,password,enabled from app_user where name = ?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
        http.formLogin().loginPage("/login");
        http.logout().logoutUrl("/logout");
        http.csrf().disable();
    }
}
