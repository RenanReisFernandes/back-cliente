package com.app.app_cliente.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.app_cliente.docs.ClienteControllerDocs;
import com.app.app_cliente.entities.Cliente;
import com.app.app_cliente.mapper.ClienteMapper;
import com.app.app_cliente.request.ClienteRequest;
import com.app.app_cliente.response.ClienteResponse;
import com.app.app_cliente.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController implements ClienteControllerDocs {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<ClienteResponse> salvar(@RequestBody ClienteRequest clienteRequest) {
		Cliente paraCliente = ClienteMapper.paraCliente(clienteRequest);
		Cliente clienteSalvo = clienteService.salvar(paraCliente);
		ClienteResponse clienteResponse = ClienteMapper.paraClienteResponse(clienteSalvo);
		return ResponseEntity.ok().body(clienteResponse);
	}

	@GetMapping
	public ResponseEntity<List<ClienteResponse>> listarTodos() {
		List<Cliente> lista = clienteService.listarClientes();
		List<ClienteResponse> paraClienteResponseList = ClienteMapper.paraClienteResponseList(lista);
		return ResponseEntity.status(HttpStatus.FOUND).body(paraClienteResponseList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponse> encontrarPorId(@PathVariable("id") Long id) {
		Optional<Cliente> optCliente = clienteService.buscarPorId(id);
		if (optCliente.isPresent()) {
			ClienteResponse response = ClienteMapper.paraClienteResponse(optCliente.get());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteResponse> atualizar(@RequestBody ClienteRequest clienteRequest,
			@PathVariable("id") Long id) {
		Optional<Cliente> clienteEncontrado = clienteService.buscarPorId(id);
		if (clienteEncontrado.isPresent()) {
			Cliente cliente = ClienteMapper.paraCliente(clienteRequest);
			cliente.setId(id);
			Cliente clienteAtualizado = clienteService.salvar(cliente);
			ClienteResponse clienteResponse = ClienteMapper.paraClienteResponse(clienteAtualizado);
			return ResponseEntity.status(HttpStatus.OK).body(clienteResponse);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable("id") Long id) {
		Optional<Cliente> clienteOpt = clienteService.buscarPorId(id);
		if (clienteOpt.isPresent()) {
			clienteService.deletarCliente(id);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
