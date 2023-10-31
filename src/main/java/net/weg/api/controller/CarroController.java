package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.CarroEdicaoDTO;
import net.weg.api.model.entity.Carro;

import net.weg.api.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController // Anotação para indicar que é um controller
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {

    private CarroService carroService;

    @GetMapping("/seguroradora/{id}")
    public Collection<Carro> buscarCarrosSeguradora(@PathVariable Integer id){
        return carroService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable(value = "id") Integer id){
        return carroService.buscarUm(id);
    }

    @GetMapping()
    public Collection<Carro> buscarTodos(){
        return carroService.buscarTodos();
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        carroService.deletar(id);
    }

    @PostMapping()
    public ResponseEntity<Carro> inserir(@RequestBody CarroCadastroDTO carro){
       try {
           return new ResponseEntity<>(
                   carroService.salvar(carro), HttpStatus.CREATED);
       }catch (Exception e){
           return  new ResponseEntity<>(HttpStatus.CONFLICT);
       }
    }

    @PutMapping
    public void   atualizar(@RequestBody CarroEdicaoDTO carro){

        carroService.editar(carro);

    }

    @GetMapping("/marca")
    public Collection<Carro> buscarMarcaCarro(
            @RequestParam String marca){
        return carroService.buscarCarroMarca(marca);
    }
}
