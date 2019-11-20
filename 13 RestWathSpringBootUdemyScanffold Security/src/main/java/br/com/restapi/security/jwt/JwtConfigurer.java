package br.com.restapi.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	@Autowired
	private JwtTokenProvider tokenProvedier;

	public JwtConfigurer(JwtTokenProvider tokenProvedier) {
		this.tokenProvedier = tokenProvedier;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		JwtTokenFilter custonFilter = new JwtTokenFilter(tokenProvedier);
		http.addFilterBefore(custonFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
}
