package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Seguradora;

import net.weg.api.repository.SeguradoraRepository;
import net.weg.api.repository.SeguroRepository;
import net.weg.api.service.SeguradoraService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/seguradora")
public class SeguradoraController {
    private SeguradoraService seguradoraService;

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id){
        seguradoraService.deletar(id);
    }

    @PutMapping()
    public void atualizar(@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }

    @GetMapping()
    public Collection<Seguradora> buscarTodos(){
        return seguradoraService.buscar();
    }

    @GetMapping("/{id}")
    public Seguradora buscarUm(@PathVariable Integer id){
        return seguradoraService.buscar(id);
    }
}
