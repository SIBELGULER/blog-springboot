package com.example.blog.ortak;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().
                authorizeRequests()
                .antMatchers("/api/blog/*").permitAll() // #4
                .antMatchers("/api/etiket/*").permitAll() // #4
                .antMatchers("/api/kategori/*").permitAll() // #4
                .antMatchers("/api/yorum/*").permitAll() // #4
                .anyRequest().authenticated() // 7
                .and()
                .formLogin()
                .permitAll();
    }
}
