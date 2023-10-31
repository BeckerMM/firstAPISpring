package net.weg.api.view;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import net.weg.api.model.entity.Seguro;

@Route( value = "/meus-seguros", layout = AppLayoutNavbar.class)

public class MeusSeguros extends VerticalLayout {

    public MeusSeguros (){
        add(new H1("Meus Seguros"));
        add(new Grid<>(Seguro.class));
    }

}
