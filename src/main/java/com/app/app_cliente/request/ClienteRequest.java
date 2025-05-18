package com.app.app_cliente.request;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

	private String nome;
	private int idade;
	@CPF
	private String cpf;
	private String endereco;

}
