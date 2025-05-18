package com.app.app_cliente.entities;

import java.util.List;

import com.app.app_cliente.Enuns.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
    @Column(nullable = false, unique = true)
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
	private String email;
    @Column(nullable = false)
    @NotBlank(message = "A senha é obrigatória")
	private String password;
	
	private List<Role> roles;

}
