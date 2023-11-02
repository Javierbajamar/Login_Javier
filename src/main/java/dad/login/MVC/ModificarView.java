package dad.login.MVC;


import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ModificarView extends VBox {


    private Label usuario;
    private TextField usuarioText;
    private Label contrasena;
    private TextField contrasenaText;
    private CheckBox ldap;
    private Button acceder;
    private Button cancelar;


    public ModificarView() {
        super();


        usuario = new Label("Usuario");
        usuarioText = new TextField("");
        usuarioText.setPromptText("Nombre de usuario");


        contrasena = new Label("Contraseña");
        contrasenaText = new TextField("");
        contrasenaText.setPromptText("Contraseña");


        ldap = new CheckBox("usar LDAP");


        acceder = new Button("Acceder");
        acceder.setDefaultButton(true);
        acceder.setOnAction(this::onAccederAction);

        cancelar = new Button("Cancelar");
        cancelar.setOnAction(this::onCancelarAction);

        HBox botonesHbox = new HBox(5, cancelar, acceder);

        //Gridpane
        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setPadding(new Insets(5));
        gridPane.addRow(0, usuario, usuarioText);
        gridPane.addRow(1, contrasena, contrasenaText);
        gridPane.addRow(2, new Label(""), ldap);
        gridPane.addRow(3, new Label(""), botonesHbox);


        setSpacing(5);
        setFillWidth(false);
        setAlignment(Pos.CENTER);
        getChildren().addAll(gridPane);
    }


    public Label getUsuario() {
        return usuario;
    }

    public TextField getUsuarioText() {
        return usuarioText;
    }

    public Label getContrasena() {
        return contrasena;
    }

    public TextField getContrasenaText() {
        return contrasenaText;
    }

    public CheckBox getLdap() {
        return ldap;
    }

    public Button getAcceder() {
        return acceder;
    }

    public Button getCancelar() {
        return cancelar;
    }

    private void onAccederAction(ActionEvent event) {
        System.out.println("Acceder");
    }

    private void onCancelarAction(ActionEvent event) {
        System.out.println("Cancelar");

    }


}
