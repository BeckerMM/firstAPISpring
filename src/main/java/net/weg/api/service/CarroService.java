package net.weg.api.service;


import lombok.AllArgsConstructor;
import net.weg.api.model.Carro;
import net.weg.api.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CarroService {
    private final CarroRepository carroRepository;

    public Carro buscarUm(Integer id) {
        Optional<Carro> carro = carroRepository.findById(id);
        return carro.get();
    }

    public Collection<Carro> buscarTodos() {
        return carroRepository.findAll();
    }

    public void deletar(Integer id) {
        carroRepository.deleteById(id);
    }

    public void salvar(Carro carro) {
        carroRepository.save(carro);
    }

}
