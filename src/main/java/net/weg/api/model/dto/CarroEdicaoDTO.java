package net.weg.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarroEdicaoDTO {
    private String marca;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;
    private String placa;

}
