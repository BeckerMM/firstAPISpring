package net.weg.api.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.model.entity.Usuario;
import net.weg.api.service.CarroService;
import net.weg.api.service.SeguradoraService;
import net.weg.api.service.SeguroService;
import net.weg.api.service.UsuarioService;

public class CadastroSeguro extends FormLayout {

    private SeguroService seguroService;


    CadastroSeguro(SeguradoraService seguradoraService,
                   CarroService carroService ,
                   UsuarioService usuarioService,
                   SeguroService seguroService,
                   Dialog dialog) {

        this.seguroService = seguroService;
        NumberField valor = new NumberField("Valor");
        TextField descricao = new TextField("Descrição");
        NumberField valorDaFranquia = new NumberField("Valor da Franquia");
        Select<Seguradora> seguradoraSelect = new Select<>();
        seguradoraSelect.setLabel("Seguradora");
        seguradoraSelect.setItems(seguradoraService.buscar());
        Select<Carro> carroSelect = new Select<>();
        carroSelect.setLabel("Carros");
        carroSelect.setItems(carroService.buscarTodos());
        Select<Cliente> usuarioSelect = new Select<>();
//        usuarioSelect.setItemLabelGenerator(item ->toString());
        usuarioSelect.setLabel("Usuários");
        usuarioSelect.setItems(usuarioService.buscarTodos());


        Button saveButton = new Button("Salvar", event -> {


            SeguroCadastroDTO seguroCadastroDTO = new SeguroCadastroDTO(valor.getValue(),
                    descricao.getValue(),
                    valorDaFranquia.getValue(),
                    seguradoraSelect.getValue(),
                    carroSelect.getValue(),
                    usuarioSelect.getValue());

            try {
                seguroService.salvar(seguroCadastroDTO);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            dialog.close();

        });

        Button buttonCancelar = new Button("Cancelar", event -> dialog.close() );
        dialog.getFooter().add(buttonCancelar,saveButton);


        add(valor,valorDaFranquia,descricao, carroSelect, seguradoraSelect,usuarioSelect);
    }
}
