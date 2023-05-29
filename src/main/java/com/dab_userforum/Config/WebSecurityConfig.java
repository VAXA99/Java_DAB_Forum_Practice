package com.dab_userforum.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceConfig userService;

    @Async
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                    .antMatchers("/", "/?").permitAll()
                    .antMatchers("/admin/**", "/?").hasRole("admin")
                .and()
                    .formLogin()
                    .loginPage("/sign_in")
                    .defaultSuccessUrl("/admin")
                    .permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                    .permitAll();
    }

    @Autowired
    @Async
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService);
    }


}
