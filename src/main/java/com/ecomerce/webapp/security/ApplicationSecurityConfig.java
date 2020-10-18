package com.ecomerce.webapp.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	PasswordEncoder passworEndoder;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","index","/css/*","/js/*").permitAll()
//		.antMatchers("/webapione/admin/**").hasRole(ApplicationUserRole.ADMIN.name())
//		.antMatchers("/webapione/persons/**").hasAuthority(ApplicationUserPermission.USER_READ.getPermission())
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		
		UserDetails johnSmith = User.builder().username("johnsmith")
				.password(passworEndoder.encode("password"))
				.authorities(ApplicationUserRole.USER.getGrandtedAuthorities())
//				.roles(ApplicationUserRole.USER.name())
				.build();
		
		UserDetails annaSmith = User.builder().username("annasmith")
				.password(passworEndoder.encode("password@123"))
				.authorities(ApplicationUserRole.USER.getGrandtedAuthorities())
//				.roles(ApplicationUserRole.VENDOR.name())
				.build();
		
		UserDetails mikeSmith = User.builder().username("mikesmith")
				.password(passworEndoder.encode("password@121"))
				.authorities(ApplicationUserRole.ADMIN.getGrandtedAuthorities())
//				.roles(ApplicationUserRole.ADMIN.name())
				.build();
		
		return new InMemoryUserDetailsManager(
				johnSmith, annaSmith , mikeSmith
				);
		
	}
	

}
