package com.example.springboot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configurable
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BCryptPasswordEncoder pe;

    //Mã Hóa mật khẩu
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(pe.encode("123")).roles("USERS")
                .and().withUser("admin").password(pe.encode("123")).roles("ADMIN")
                .and().withUser("guest").password(pe.encode("123")).roles("");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable();

        http
                .authorizeRequests()
                .antMatchers("/rest/customer").hasRole("ADMIN")
                .antMatchers("/rest/category").hasAnyRole("ADMIN","USERS")
                .antMatchers("/book").permitAll()
                .anyRequest().authenticated();

        http
                .httpBasic();
    }
}
