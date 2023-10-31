package dad.login.MVC;

import javafx.event.ActionEvent;

public class ModificarController {

    //view

    private ModificarView view = new ModificarView();

    //model

    private Model model = new Model();

    public ModificarController() {

        view.getUsuarioText().textProperty().bindBidirectional(model.usuarioProperty());
        view.getContrasenaText().textProperty().bindBidirectional(model.contrasenaProperty());


        view.getAcceder().setOnAction(this::onAccederAction);
        view.getCancelar().setOnAction(this::onCancelarAction);

    }

    private void onCancelarAction(ActionEvent actionEvent) {
    }

    private void onAccederAction(ActionEvent actionEvent) {
    }
}
