package net.weg.api.service;


import net.weg.api.model.Usuario;
import net.weg.api.repository.CarroDAO;
import net.weg.api.repository.UsuarioDAO;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service // Define que é uma camada de serviço
public class UsuarioService {

    private final UsuarioDAO usuarioDAO;
    private final CarroService carroService;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
        carroService = new CarroService();
    }

    public void inserir(Usuario usuario) {
        try {
            carroService.buscarUm(usuario.getCarro().getId());
        } catch (NoSuchElementException e) {
            carroService.inserir(usuario.getCarro());
        }
        usuarioDAO.inserir(usuario);
    }

    public Usuario buscarUm(Integer id) {
        Usuario usuario = usuarioDAO.buscarUm(id);
        try {
            usuario.setCarro(carroService.buscarUm(
                    usuario.getCarro().getId()
            ));
        } catch (Exception ignore) {
        }
        return usuario;
    }

    public Collection<Usuario> buscarTodos() {

        Collection<Usuario> usuarios = usuarioDAO.buscarTodos();

            for (Usuario usuario: usuarios
                 ) {
             try{
                 usuario.setCarro(
                         carroService.buscarUm(usuario.getId())
                 );
             }   catch (Exception ignore){}

        }
        return usuarioDAO.buscarTodos();
    }

    public void deletar(Integer id) {
        usuarioDAO.deletar(id);
    }

    public void atualizar(Usuario usuario) {
        try {
            carroService.buscarUm(usuario.getCarro().getId());
        } catch (NoSuchElementException e) {
            carroService.inserir(usuario.getCarro());
        }
        usuarioDAO.atualizar(usuario);
    }
}
