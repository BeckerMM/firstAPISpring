package net.weg.api.service;


import net.weg.api.model.Carro;
import net.weg.api.repository.CarroDAO;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Service
public class CarroService {
    private final CarroDAO carroDAO;

    public CarroService() {
        this.carroDAO = new CarroDAO();
    }

    public Carro buscarUm(Integer id) {
        return carroDAO.buscarUm(id);
    }

    public Collection<Carro> buscarTodos() {
        return carroDAO.buscarTodos();
    }

    public void deletar(Integer id) {
        carroDAO.deletar(id);
    }

    public void inserir(Carro carro) {
        carroDAO.inserir(carro);
    }

    public void atualizar(Carro carro) {
        carroDAO.atualizar(carro);
    }

}
