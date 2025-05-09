package com.example.arquitetura.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.arquitetura.domain.Cliente;
import com.example.arquitetura.repository.ClienteRepository;




@RestController
@RequestMapping("/clientes")
public class ClienteController{

private final ClienteRepository repository;

public ClienteController (ClienteRepository repository) {
    this.repository = repository;
}
@GetMapping
    public List<Cliente> listarTodos(){
        return repository.findAll();
        
    }
    
}
