package com.app.app_cliente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.app_cliente.entities.Cliente;
import com.app.app_cliente.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		Cliente clienteSalvo = clienteRepository.save(cliente);
		return clienteSalvo;
	}

	public List<Cliente> listarClientes() {
		List<Cliente> clienteSalvo = clienteRepository.findAll();
		return clienteSalvo;
	}

	public Optional<Cliente> buscarPorId(Long id) {
		Optional<Cliente> clienteCapturado = clienteRepository.findById(id);
		return clienteCapturado;
	}

	public Optional<Cliente> atualizar(Cliente clienteAtualizado, Long id) {
		Optional<Cliente> clienteOpt = clienteRepository.findById(id);
		if (clienteOpt.isPresent()) {
			Cliente clienteEncontrado = clienteOpt.get();
			clienteEncontrado.setNome(clienteAtualizado.getNome());
			clienteEncontrado.setIdade(clienteAtualizado.getIdade());
			clienteEncontrado.setCpf(clienteAtualizado.getCpf());
			clienteEncontrado.setEndereco(clienteAtualizado.getEndereco());

			Cliente clienteFinalizado = clienteRepository.save(clienteEncontrado);
			return Optional.of(clienteFinalizado);

		}

		return Optional.empty();
	}

	public void deletarCliente(Long id) {
		if (clienteRepository.findById(id).isEmpty()) {
			System.out.println("Cliente não encontrado!");
		}
		clienteRepository.deleteById(id);
		System.out.println("Cliente deletado com sucesso!");

	}

}
