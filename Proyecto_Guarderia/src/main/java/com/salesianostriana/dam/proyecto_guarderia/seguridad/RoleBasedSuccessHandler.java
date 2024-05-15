package com.salesianostriana.dam.proyecto_guarderia.seguridad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;

@Component
@Log
public class RoleBasedSuccessHandler implements AuthenticationSuccessHandler {
			
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		// Lógica de redirección	
		// Determinar el rol de más privilegios, si el usuario tiene más de uno
		String role = getMaxRole(authentication.getAuthorities());
	}
	

	private String getMaxRole(Collection<? extends GrantedAuthority> collection) {
		List<GrantedAuthority> authoritiesList =
		new ArrayList<>(collection);
				
		// Usuario autenticado pero sin rol
		if (authoritiesList.isEmpty())
			return "ROLE_DEFAULT";
				
			return authoritiesList
				.stream()
				.map(GrantedAuthority::getAuthority)
				.sorted((role1, role2) -> role_weight.getOrDefault(role2, Integer.MIN_VALUE) - role_weight.getOrDefault(role1, Integer.MIN_VALUE))
				.findFirst()
				.get();		
	}

	
	private static Map<String, Integer> role_weight = Map.of("ROLE_ADMIN", 10, "ROLE_USER", 1);
			
			
}