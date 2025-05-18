package com.app.app_cliente.docs;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.app_cliente.request.ClienteRequest;
import com.app.app_cliente.response.ClienteResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface ClienteControllerDocs {

	@Operation(summary = "Salvar novo cliente")
	ResponseEntity<ClienteResponse> salvar(ClienteRequest clienteRequest);

	@Operation(summary = "Listar todos os clientes")
	ResponseEntity<List<ClienteResponse>> listarTodos();

	@Operation(summary = "Buscar cliente por ID", responses = {
			@ApiResponse(responseCode = "200", description = "Cliente encontrado"),
			@ApiResponse(responseCode = "404", description = "Cliente não encontrado") })
	ResponseEntity<ClienteResponse> encontrarPorId(@PathVariable("id") Long id);

	@Operation(summary = "Atualizar cliente por ID")
	ResponseEntity<ClienteResponse> atualizar(@RequestBody ClienteRequest clienteRequest, @PathVariable("id") Long id);

	@Operation(summary = "Excluir cliente por ID")
	ResponseEntity<Void> deletarCliente(@PathVariable("id") Long id);

}
