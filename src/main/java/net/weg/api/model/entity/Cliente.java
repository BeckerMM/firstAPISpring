package net.weg.api.model.entity;

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
@ToString(callSuper = true)
@Table(name = "tb_cliente")
public class Cliente extends Usuario {

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Carro> carro;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER) // sempre colocar no one to many
    private Set<Seguro> seguros;

    @Override
    public String toString() {
        return super.toString();
    }
}
