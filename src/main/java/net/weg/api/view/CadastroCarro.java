package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.service.CarroService;

import java.util.List;

public class CadastroCarro extends FormLayout {

    private final CarroService carroService;

    public CadastroCarro(CarroService carroService, Dialog dialog) {
        this.carroService = carroService;
        TextField placa = new TextField("Placa");
        TextField marca = new TextField("Marca");
        TextField cor = new TextField("Cor");
        TextField modelo = new TextField("Modelo");
        IntegerField ano= new IntegerField("Ano");
        NumberField preco = new NumberField("Preco");

        Button saveButton = new Button("Salvar", event -> {

                preco.getValue();
                CarroCadastroDTO carroCadastroDTO = new CarroCadastroDTO(marca.getValue(),
                        cor.getValue(),
                        modelo.getValue(),
                        preco.getValue(),
                        ano.getValue(),
                        placa.getValue());

                try {
                    carroService.salvar(carroCadastroDTO);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                dialog.close();

        });

        Button buttonCancelar = new Button("Cancelar", event -> dialog.close() );
        dialog.getFooter().add(buttonCancelar,saveButton);

        FormLayout cadastro = new FormLayout();
        add(placa,marca,cor,modelo,ano,preco);


    }
}
