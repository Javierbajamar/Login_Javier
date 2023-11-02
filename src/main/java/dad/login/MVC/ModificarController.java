package dad.login.MVC;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class ModificarController {

    //view

    private ModificarView view = new ModificarView();

    //model

    private Model model = new Model();

    public ModificarController() {

        view.getUsuarioText().textProperty().bindBidirectional(model.usuarioProperty());
        view.getContrasenaText().textProperty().bindBidirectional(model.contrasenaProperty());
        view.getLdap().selectedProperty().bindBidirectional(model.ldapProperty());


        view.getAcceder().setOnAction(this::onAccederAction);
        view.getCancelar().setOnAction(this::onCancelarAction);

    }

    public ModificarView getView() {
        return view;
    }

    public Model getModel() {
        return model;
    }

    private void onCancelarAction(ActionEvent actionEvent) {

        Stage stage = (Stage) view.getCancelar().getScene().getWindow();
        stage.close();

    }

    private void onAccederAction(ActionEvent actionEvent) {


        AuthService auth = model.getLdap() ? new LdapAuthService() : new FileAuthService();

        try {
            if (auth.login(model.getUsuario(), model.getContrasena())) {
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