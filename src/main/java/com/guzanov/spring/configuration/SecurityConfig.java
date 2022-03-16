package com.guzanov.spring.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private ComboPooledDataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //коннект к БД, где будут описаны все юзеры
        System.out.println("================================10");
        System.out.println(dataSource);
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //раздаем права
        System.out.println("================================11");
        http.authorizeRequests()
                    .antMatchers("/").hasAnyRole("ADMIN", "MANAGER","USER")
                    .antMatchers("/createNewEmployee").hasAnyRole("ADMIN", "MANAGER")
                    .antMatchers("/updateInfo").hasAnyRole("ADMIN")
                    .antMatchers("/saveEmployee").hasAnyRole("ADMIN", "MANAGER")
                    .antMatchers("/getDetail").hasAnyRole("ADMIN", "MANAGER","USER")
                    .antMatchers("/updateDetail").hasAnyRole("ADMIN", "MANAGER")
                    .antMatchers("/saveDetail").hasAnyRole("ADMIN", "MANAGER")
                    .antMatchers("/getDepartment").hasAnyRole("ADMIN", "MANAGER","USER")
                    .antMatchers("/updateDepartment").hasAnyRole("ADMIN")
                    .antMatchers("/saveDepartment").hasAnyRole("ADMIN")
                    .antMatchers("/deleteEmployee").hasAnyRole("ADMIN")
                    .antMatchers("/redirectToStartPage").hasAnyRole("ADMIN", "MANAGER","USER")
                .and()
                    .formLogin()
                    .permitAll();
    }
}
