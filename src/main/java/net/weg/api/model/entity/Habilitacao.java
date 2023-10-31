package net.weg.api.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Habilitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// cria o resgistro a partir da tabela
    private Integer id;
    private Long registro,cpf;
    private String orgao;
}
