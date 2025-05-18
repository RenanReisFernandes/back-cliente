package com.app.app_cliente.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.app.app_cliente.entities.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class TokenService {
	
	@Value("${security.secretLoginKey}")
	private String secret;
	
	public String generateToken(User user) {
		
		Algorithm algorithm = Algorithm.HMAC256(secret);
		
		return JWT.create()
				.withIssuer("app-cliente")
				.withClaim("userId", user.getId())
				.withSubject(user.getEmail())
				.withClaim("roles",user.getRoles().stream().map(Enum:: name).toList())
				.withExpiresAt(Instant.now().plusSeconds(86400))
				.withIssuedAt(Instant.now())
				.sign(algorithm);
	}

}
