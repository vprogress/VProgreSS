package com.VProgreSS.demo.Seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService((userDetailsService));
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/welcomeEnterprise").hasRole("USER,ADMIN")
                .antMatchers("/").permitAll()
                .antMatchers("/login*").permitAll()
                .antMatchers("/userList").permitAll()
                .antMatchers("/oauth/**").permitAll()

                .and()

                .formLogin()
                .loginPage("/loginUser")
                .usernameParameter("userApplication")
                .passwordParameter("passwordUser")
                .defaultSuccessUrl("/WelcomeUser")

        ;
        http.csrf().disable();
    }
}
