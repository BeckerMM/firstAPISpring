package net.weg.api.service;

import lombok.AllArgsConstructor;

import net.weg.api.model.entity.Seguro;
import net.weg.api.repository.SeguroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SeguroService {

    private SeguroRepository seguroRepository;

    public void salvar(Seguro Seguro) {
        seguroRepository.save(Seguro);
    }

    public void deletar(Integer id){
        seguroRepository.deleteById(id);
    }
    public  Seguro buscar(Integer id){
        return seguroRepository.findById(id).get();
    }

    public List<Seguro> buscar(){
        return seguroRepository.findAll();
    }
}
