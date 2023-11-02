package dad.login.MVC;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private final ModificarController controller = new ModificarController();


    @Override
    public void start(Stage stage) throws Exception {

        //TODO ModificarController y ya, lo demas esta done

        Scene scene = new Scene(controller.getView(), 350, 200);

        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();


    }
}
