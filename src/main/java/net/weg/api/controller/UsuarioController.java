package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.Usuario;
import net.weg.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

// Controller serve para fazer o mapeamento, pouca lógica
@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;


    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable(value = "id") Integer id){
        return usuarioService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Usuario> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam("value") Integer id){
        usuarioService.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Usuario usuario){
       usuarioService.salvar(usuario);
    }

    @PutMapping
    public void atualizar(@RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
    }
}
