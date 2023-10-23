package net.weg.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToOne(mappedBy = "veiculo")
    private Seguro seguro;

}
