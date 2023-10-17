package net.weg.api.controller;

import net.weg.api.model.Carro;
import net.weg.api.model.Usuario;
import net.weg.api.repository.CarroDAO;
import net.weg.api.repository.UsuarioDAO;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController // Anotação para indicar que é um controller
@RequestMapping("/carro")
public class CarroController {
    private CarroDAO carroDAO = new CarroDAO();

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable(value = "id") Integer id){
        return carroDAO.buscarUm(id);
    }

    @GetMapping()
    public Collection<Carro> buscarTodos(){
        return carroDAO.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        carroDAO.deletar(id);
    }

    @PostMapping()
    public void inserir(@RequestBody Carro carro){
        carroDAO.inserir(carro);
    }

    @PutMapping
    public void atualizar(@RequestBody Carro carro){
        carroDAO.atualizar(carro);
    }
}
