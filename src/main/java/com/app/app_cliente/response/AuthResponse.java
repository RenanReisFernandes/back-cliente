package com.app.app_cliente.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {
	
	@JsonProperty("access_token")
	private String accessToken;
	
	private String nome;

}
