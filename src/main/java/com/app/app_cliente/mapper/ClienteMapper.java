package com.app.app_cliente.mapper;

import java.util.ArrayList;
import java.util.List;

import com.app.app_cliente.entities.Cliente;
import com.app.app_cliente.request.ClienteRequest;
import com.app.app_cliente.response.ClienteResponse;

public class ClienteMapper {

	public static Cliente paraCliente(ClienteRequest clienteRequest) {
		Cliente cliente = new Cliente();

		cliente.setNome(clienteRequest.getNome());
		cliente.setIdade(clienteRequest.getIdade());
		cliente.setCpf(clienteRequest.getCpf());
		cliente.setEndereco(clienteRequest.getEndereco());
		return cliente;
	}
	
	public static ClienteResponse paraClienteResponse(Cliente cliente) {
		ClienteResponse clienteResponse = new ClienteResponse();
		
		clienteResponse.setNome(cliente.getNome());
		clienteResponse.setIdade(cliente.getIdade());
		clienteResponse.setEndereco(cliente.getEndereco());
		return clienteResponse;
	}
	
	public static List<ClienteResponse> paraClienteResponseList(List<Cliente> clienteList){
		List<ClienteResponse> responseList = new ArrayList<>();
		for(Cliente cliente: clienteList) {
			responseList.add(paraClienteResponse(cliente));
		}
		return responseList;
	}

}
