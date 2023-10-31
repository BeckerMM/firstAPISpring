package net.weg.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "tb_seguradora")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seguradora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long cnpj;
    private String nome;
    @OneToOne
    private Endereco endereco;
    @ManyToMany
    // @JsonIgnore // atributo que estiver com está anotação será ignorado
    private Set<Cliente> clientes;
}