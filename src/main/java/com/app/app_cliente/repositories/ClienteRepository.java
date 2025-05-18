package com.app.app_cliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.app_cliente.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
