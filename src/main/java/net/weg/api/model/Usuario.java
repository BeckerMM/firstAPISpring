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
@Table(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username",unique = true, nullable = false)
    private String usuario;
    private String senha;
    private Integer idade;
    @OneToMany (cascade = CascadeType.PERSIST)
    private Set<Carro> carro;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<String> endereco;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @ManyToOne
    private Consorcio consorcio;

}
