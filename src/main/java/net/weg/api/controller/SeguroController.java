package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.SeguroCadastroDTO;
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
    public void remover(@PathVariable Integer id, @PathVariable Integer seguradoraId){
     seguroService.deletar(id,seguradoraId);
    }

    @PutMapping()
    public void atualizar(@RequestBody SeguroCadastroDTO seguroCadastroDTO){
        seguroService.salvar(seguroCadastroDTO);
    }

    @GetMapping()
    public Collection<Seguro> buscarTodos(){
        return seguroService.buscar();
    }

    @GetMapping("/{id}")
    public Seguro buscarUm(@PathVariable Integer id,
                           @PathVariable Integer seguradoraId){
        return seguroService.buscar(id,seguradoraId);
    }


}
