package com.salesianostriana.dam.proyecto_guarderia.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{

		
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	//private final AuthenticationSuccessHandler authenticationSuccessHandler;

	
	/*@Bean
	InMemoryUserDetailsManager userDetailsService() {
		UserDetails admin = User.builder()
				.username("admin")
				.password("{noop}admin")
				.roles("ADMIN", "USER").build();
		
		UserDetails user = User.builder()
				.username("user")
				.password("{noop}1234")
				.roles("USER").build();
		
		UserDetails user2 = User.builder()
				.username("user2")
				.password("{noop}5678")
				.roles("OTHER").build();
		
		
		return new InMemoryUserDetailsManager(user, admin, user2);
	}*/
	
	
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		
		AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		
		return authBuilder.authenticationProvider(daoAuthenticationProvider()).build();
	}
	
	
	
	@Bean 
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				(authz) -> authz.requestMatchers("/css/**", "/img/**", "/js/**", "/h2-console/**", "/", "/emplazamiento", "/normas").permitAll()
					.requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated())
			.formLogin((loginz) -> loginz.loginPage("/login").defaultSuccessUrl("/usuario/bienvenida").permitAll())
			.logout((logoutz) -> logoutz.logoutUrl("/logout").logoutSuccessUrl("/").permitAll());

		
	        // Añadimos esto para poder seguir accediendo a la consola de H2
	        // con Spring Security habilitado.
		
	        http.csrf(csrfz -> csrfz.disable());
	        http.headers(headersz -> headersz
	                .frameOptions(frameOptionsz -> frameOptionsz.disable()));

	        return http.build();
	    }

	    
}
