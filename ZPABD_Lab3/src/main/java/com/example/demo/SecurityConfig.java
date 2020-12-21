package com.example.demo;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	//ZASTAPIC TO Z USERAMI Z BAZY DANYCH
	//ROLE PLUS UZYTKOWNICY
	//HASLO HASHOWANE
	
	@Autowired
    private DataSource dataSource;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    	auth.jdbcAuthentication().dataSource(dataSource)
//    	.usersByUsernameQuery("select username, password, enabled from users where username = ?")
//        .authoritiesByUsernameQuery("select username, authority from authorities where username = ?")
//        .passwordEncoder(new BCryptPasswordEncoder());
//    	
//    	System.out.println("///////////////////////");
//    	System.out.println(dataSource);
//    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    	System.out.println("11111111111111111111111111");
//    	System.out.println(passwordEncoder.encode("user"));
//    	System.out.println("2222222222222222222222222");
//    	System.out.println(passwordEncoder.encode("guest"));
//    	System.out.println("3333333333333333333333333333");
//    	System.out.println(passwordEncoder.encode("admin"));
//    	System.out.println("///////////////////////");
//    }
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails guest = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
				.username("guest")
				.password("guestPass")
				.roles("GUEST")
				.build();
		
		UserDetails user = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
				.username("user")
				.password("userPass")
				.roles("USER")
				.build();
		
		UserDetails admin = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
				.username("admin")
				.password("adminPass")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(guest, user, admin);
	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic().and().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api/employees/all").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api/employees/delete").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/api/employees/add").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.GET, "/api/employees/id").hasRole("USER")
		.antMatchers(HttpMethod.GET, "/api/department/all").permitAll()
		.antMatchers(HttpMethod.GET, "/api/department/id").hasAnyRole("USER", "ADMIN")
		.antMatchers(HttpMethod.POST, "/api/department/add").hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/department/delete").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/department/update").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/department/addToDept").hasRole("ADMIN")
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll()
		.and()
		.csrf().disable();
	}
}
