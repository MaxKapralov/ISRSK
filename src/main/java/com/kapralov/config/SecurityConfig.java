package com.kapralov.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
     
	@Autowired 
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
	{
    	auth.jdbcAuthentication().dataSource(dataSource)
    	.passwordEncoder(passwordEncoder())
    	.usersByUsernameQuery(
    			"select login as username, password, 1 as enabled from users where login=?")
    		.authoritiesByUsernameQuery(
    			"select users.login as username, user_info.role as role from user_info join users on user_info.id_user = users.id_user where login=?");
	}
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
    	http.authorizeRequests()
		.antMatchers("/", "/login*", "/result", "/register").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated()
  	.and()
  		.formLogin().loginPage("/login")
  		.usernameParameter("login").passwordParameter("password")
  		.defaultSuccessUrl("/mainPage")
  		.failureUrl("/login?error=true")
  	.and()
  		.csrf()
  	.and()
  		.exceptionHandling().accessDeniedPage("/accessDenied");
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}