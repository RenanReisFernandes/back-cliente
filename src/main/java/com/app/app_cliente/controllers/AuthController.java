package com.app.app_cliente.controllers;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.app_cliente.request.AuthRequest;
import com.app.app_cliente.response.AuthResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
		
		UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
		Authentication authenticate = AuthenticationManager.authenticate(userAndPass);
		
		User user = (User) authenticate.getPrincipal();
		String token = tokenService.generateToken(user);
		
		return ResponseEntity.ok(AuthResponse.builder()
				.accessToken(token)
				.nome(user.getName())
				.build());
	}

}
