package net.weg.api.model.dto;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.api.model.entity.Endereco;
import net.weg.api.service.UsuarioService;

import java.util.Set;

@Data
@AllArgsConstructor

public class UsuarioDTO {

    private String nome;
    private String sobrenome;
    private String usuario;
    private String senha;
    private Integer idade;
    private Set<Endereco> enderecos;



}
