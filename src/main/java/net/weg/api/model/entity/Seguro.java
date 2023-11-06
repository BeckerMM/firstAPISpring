package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_plano")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seguro {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
    @EmbeddedId // sempre que tiver uma chave composta utiliza est? anota??o
    private SeguroId id = new SeguroId();
    private Double valor;
    private String nome;
    private String descricao;
    private Double valorFranquia;
    @ManyToOne
    @MapsId("seguradoraId")
    private Seguradora seguradora;
    @OneToOne
//    @MapsId("veculoId")
    private Carro veiculo;
    @ManyToOne
    private Cliente cliente;
}