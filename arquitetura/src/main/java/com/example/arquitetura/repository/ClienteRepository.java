package com.example.arquitetura.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.arquitetura.domain.Cliente;

@Repository
public class ClienteRepository {
    private List<Cliente> clientes;

public ClienteRepository(){
    this.clientes = new ArrayList<>();

    Cliente cliente1 = Cliente.builder()
                    .codigo(1)
                    .nome("Giba")
                    .build();

                    Cliente cliente2 = Cliente.builder()
                    .codigo(2)
                    .nome("Andressa")
                    .build();

                    Cliente cliente3 = new Cliente(3, "Sheilha");
                    
                    clientes.add(cliente1);
                    clientes.add(cliente2);
                    clientes.add(cliente3);
}
public List<Cliente> findAll(){
    return clientes;
}
}
