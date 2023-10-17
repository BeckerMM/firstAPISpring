package net.weg.api.controller;

import net.weg.api.model.Usuario;
import net.weg.api.repository.UsuarioDAO;
import net.weg.api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


// Controller serve para fazer o mapeamento, pouca lógica
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private UsuarioService usuarioService = new UsuarioService();

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable(value = "id") Integer id){
        return usuarioDAO.buscarUm(id);
    }

    @GetMapping()
    public Collection<Usuario> buscarTodos(){
        return usuarioDAO.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        usuarioDAO.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Usuario usuario){
       usuarioService.inserir(usuario);
    }

    @PutMapping
    public void atualizar(@RequestBody Usuario usuario){
        usuarioDAO.atualizar(usuario);
    }
}
