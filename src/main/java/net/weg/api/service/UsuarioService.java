package net.weg.api.service;


import lombok.AllArgsConstructor;

import net.weg.api.model.dto.UsuarioDTO;
import net.weg.api.model.entity.Cliente;
import net.weg.api.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service // Define que é uma camada de serviço
@AllArgsConstructor

public class UsuarioService {

    private final ClienteRepository clienteRepository;
    private final CarroService carroService;


    public void salvar(UsuarioDTO usuarioDTO) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(usuarioDTO,cliente);
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
