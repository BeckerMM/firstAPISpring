package net.weg.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

//@Getter
//@Setter
//@ToString

@Data // faz todas as anotações acima
@AllArgsConstructor
@NoArgsConstructor
@Entity //Ele considera a classe uma entidade, assim criando uma tabela para está entidade
@Table(name = "tb_cliente")
public class Cliente extends Usuario {

    @OneToMany
    private Set<Carro> carro;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @OneToMany(mappedBy = "cliente") // sempre colocar no one to many
    private Set<Seguro> seguros;

}
