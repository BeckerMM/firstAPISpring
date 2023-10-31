package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.model.dto.CarroCadastroDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_carro")
public class Carro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marca;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;
    private String placa;
    @OneToOne(mappedBy = "veiculo")
    private Seguro seguro;

    public Carro(CarroCadastroDTO carroDTO) {

        this.ano = carroDTO.getAno();
        this.cor = carroDTO.getCor();
        this.marca = carroDTO.getMarca();
        this.modelo = carroDTO.getModelo();
        this.preco  = carroDTO.getPreco();
    }


}
