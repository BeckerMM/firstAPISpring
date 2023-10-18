package net.weg.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Habilitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)// cria o resgistro a partir da tabela
    private Integer id;
    private Long registro,cpf;
    private String orgao;
}
