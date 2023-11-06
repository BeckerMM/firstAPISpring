package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.UsuarioDTO;
import net.weg.api.model.entity.Cliente;
import net.weg.api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

// Controller serve para fazer o mapeamento, pouca lógica
@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private final UsuarioService usuarioService;


    @GetMapping("/{id}")
    public Cliente buscarUsuario(@PathVariable(value = "id") Integer id){
        return usuarioService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Cliente> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam("value") Integer id){
        usuarioService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody UsuarioDTO cliente){
       usuarioService.salvar(cliente);
    }

    @PutMapping
    public void atualizar(@RequestBody UsuarioDTO cliente){
        usuarioService.salvar(cliente);
    }

}
