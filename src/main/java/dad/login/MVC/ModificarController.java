package dad.login.MVC;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ModificarController implements Initializable {


    //model
    private StringProperty usuario = new SimpleStringProperty();
    private StringProperty contrasena = new SimpleStringProperty();
    private BooleanProperty ldap = new SimpleBooleanProperty();

    //view

    @FXML
    private HBox botonesHbox;

    @FXML
    private TextField contrasenaText;

    @FXML
    private VBox view;

    @FXML
    private CheckBox CheckBox;
    @FXML
    private TextField usuarioText;

    public ModificarController() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MenuView.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        usuario.bind(usuarioText.textProperty());
        contrasena.bind(contrasenaText.textProperty());
        ldap.bind(CheckBox.selectedProperty());

    }

    public VBox getView() {
        return view;

    }


    @FXML
    private void onCancelarAction(ActionEvent actionEvent) {

        System.exit(0);


    }

    @FXML
    private void onAccederAction(ActionEvent actionEvent) {


        AuthService auth = ldap.get() ? new LdapAuthService() : new FileAuthService();

        try {
            if (auth.login(usuario.get(), contrasena.get())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Acceso concedido");
                alert.setHeaderText("Usuario y contraseña correctos");
                alert.setContentText("Acceso concedido");
                alert.showAndWait();

                alert.close();


            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Acceso denegado");
                alert.setHeaderText("Usuario y contraseña incorrectos");
                alert.setContentText("Acceso denegado");
                alert.showAndWait();

            }
        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Acceso denegado");
            alert.setHeaderText("Usuario y contraseña incorrectos");
            alert.setContentText("Acceso denegado");
            alert.showAndWait();

            e.printStackTrace();


        }


    }
}
