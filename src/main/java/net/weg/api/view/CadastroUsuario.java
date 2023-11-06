package net.weg.api.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import net.weg.api.model.dto.EnderecoCadastroDTO;
import net.weg.api.model.dto.UsuarioDTO;
import net.weg.api.model.entity.Endereco;
import net.weg.api.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import java.util.HashSet;
import java.util.Set;


@Route(value = "/cadastro-usuario", layout = AppLayoutNavbar.class)
public class CadastroUsuario extends FormLayout {

    private TextField nome = new TextField("Nome");
    private TextField sobrenome = new TextField("Sobrenome");

    private final TextField usuario = new TextField("Usuário");
    private final PasswordField senha = new PasswordField("Senha");
    private final PasswordField confirmacaoSenha = new PasswordField("Confimar Senha");
    private final IntegerField idade = new IntegerField("Idade");
    private final Grid<EnderecoCadastroDTO> enderecos = new Grid<>(EnderecoCadastroDTO.class);
    private final Dialog cadastroEnderecos = new Dialog();

    private Button salvar;
    private Button cancelar;
    private UsuarioService usuarioService;
    private Button novoEndereco;



    CadastroUsuario( UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        cadastroEnderecos.add(new CadastroEndereco(
                enderecos,
                cadastroEnderecos));
        novoEndereco = new Button("Novo Endereco", event -> {
            cadastroEnderecos.open();
        });

        salvar = new Button("salvar",
                event -> {
                    Notification notification = new Notification();
            try {
                if(!senha.getValue().equals(confirmacaoSenha.getValue())){
                    throw new    RuntimeException();
                }
                Set<Endereco> enderecos1 = new HashSet<>();
                enderecos.getListDataView().getItems().forEach(
                        enderecoCadastroDTO -> {
                            Endereco endereco = new Endereco();
                            BeanUtils.copyProperties(enderecoCadastroDTO,endereco);
                            enderecos1.add(endereco);
                        });
                usuarioService.salvar(new UsuarioDTO(
                        nome.getValue(),
                        sobrenome.getValue(),
                        usuario.getValue(),
                        senha.getValue(),
                        idade.getValue(),
                        enderecos1));

                notification.setDuration(3000);
                notification.setText("usuário cadastrado com sucesso!");
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            }catch (Exception e){
                notification.setText("Erro no cadastro do usuário!");
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            }finally {
                notification.open();
            }});
        cancelar = new Button("Cancelar", event -> {new UI().navigate("/");
        });

        add(nome, sobrenome ,usuario, senha, confirmacaoSenha,idade, enderecos,novoEndereco, enderecos,cancelar,salvar);
    }

}
