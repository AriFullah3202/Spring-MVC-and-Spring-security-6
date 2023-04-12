package com.test001.security_config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	public DataSource dataSource;

//	@Bean
//	public UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.withUsername("arif").password("password").roles("ADMIN").build());
//		manager.createUser(User.withUsername("sumon").password("password").roles("USER").build());
//		return manager;
//	}

	
	  @Bean
	  public JdbcUserDetailsManager users() { 
	  JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
	  jdbcUserDetailsManager.setDataSource(dataSource);
	  jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT email, password, enable FROM customer.customer where email = ?;"); 
	  jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT email , role FROM customer.customer where email =?;"); 
	  return jdbcUserDetailsManager;
	 
	  }
	  
//	  @Bean
//	  UserDetailsManager users(DataSource dataSource) {
//	  	JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//	  	JdbcUserDetailsManager users1 = new JdbcUserDetailsManager(dataSource);
//
//	  	return users;
//	  }
	  
  @Bean
	  public JdbcUserDetailsManager users1() { 
  JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
jdbcUserDetailsManager.setDataSource(dataSource);
	  jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_name, password, enable FROM customer.customer where user_name = ?;"); 
 jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_name , role FROM customer.customer where user_name =?;"); 
return jdbcUserDetailsManager;
	 
	  }

  
	 

	@Bean
	public PasswordEncoder getEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/allvisitor", "/", "/insert" , "/process-insert").permitAll()
				.requestMatchers("/admin").hasAuthority("ADMIN")
				// .requestMatchers("/customer").hasAnyRole("ADMIN","USER")
				.requestMatchers("/alluser").hasAnyAuthority("ADMIN", "USER").anyRequest().authenticated());
        http.formLogin(withDefaults());
        http.csrf().disable();
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/WEB-INF/**");
	}
	
	
	

}
