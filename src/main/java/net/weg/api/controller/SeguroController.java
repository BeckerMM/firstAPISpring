package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Seguro;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/seguro")
@AllArgsConstructor
public class SeguroController {
    private SeguroService seguroService;

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id){
     seguroService.deletar(id);
    }

    @PutMapping()
    public void atualizar(@RequestBody Seguro seguro){
        seguroService.salvar(seguro);
    }

    @GetMapping()
    public Collection<Seguro> buscarTodos(){
        return seguroService.buscar();
    }

    @GetMapping("/{id}")
    public Seguro buscarUm(@PathVariable Integer id){
        return seguroService.buscar(id);
    }


}
