package net.weg.api.repository;


import net.weg.api.model.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

    List<Carro> findByMarca(String marca);
    Collection<Carro> findBySeguro_Seguradora_Id(Integer id);



    boolean existsByPlaca(String placa);
}
