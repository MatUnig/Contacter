package com.contacter;

import com.contacter.service.SpringDataUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation
        .web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation
        .web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .passwordEncoder(passwordEncoder());
//    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("user").roles("USER")
//                .and()
//                .withUser("admin1").password("admin123").roles("ADMIN");
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/add-user", "/home", "/login", "/registerProcess", "/registered").permitAll()
//                .antMatchers("/admin").hasAuthority("ROLE_ADMIN")
//                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/login")
//                .permitAll()
//                .defaultSuccessUrl("/homePage")
//                .failureUrl("/loginPage?error")
//                .and().logout().logoutSuccessUrl("/")
//                .permitAll()
//                .and().exceptionHandling().accessDeniedPage("/403");
//    }
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/admin/**").hasAnyRole("ADMIN")
            .anyRequest().permitAll()
            .and().formLogin().loginPage("/login").defaultSuccessUrl("/contact/short")
            .and().logout().logoutSuccessUrl("/logout")
            .permitAll()
            .and().exceptionHandling().accessDeniedPage("/403");
}
}