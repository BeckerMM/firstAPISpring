package net.weg.api.service;


import lombok.AllArgsConstructor;
import net.weg.api.model.Cliente;
import net.weg.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service // Define que é uma camada de serviço
@AllArgsConstructor

public class UsuarioService {

    private final ClienteRepository clienteRepository;
    private final CarroService carroService;


    public void salvar(Cliente cliente) {

        clienteRepository.save(cliente);
    }

    public Cliente buscarUm(Integer id) {
        return clienteRepository.findById(id).get();
    }

    public Collection<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
