package net.weg.api.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Carro;
import net.weg.api.service.CarroService;


@Route( value = "/meus-automoveis", layout = AppLayoutNavbar.class)

public class MeusAutomoveis extends VerticalLayout {

    public MeusAutomoveis(CarroService carroService){

        HorizontalLayout horizontalLayout =
                new HorizontalLayout();
        horizontalLayout.add(new H1("Meus Automóveis"));
        Dialog cadastro = new Dialog();
        cadastro.add(new CadastroCarro(carroService, cadastro));

        horizontalLayout.add(new Button("Novo Carro", e -> cadastro.open()  ));
        add(horizontalLayout);
        Grid<Carro> grid = new Grid<>(Carro.class);
        grid.setItems(carroService.buscarTodos());
        add(grid    );
    }

}
