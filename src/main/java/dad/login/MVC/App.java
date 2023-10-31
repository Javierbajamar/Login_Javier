package dad.login.MVC;

import dad.login.MVC.ModificarView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        //TODO ModificarController y ya, lo demas esta done

        Scene scene = new Scene(new ModificarView(), 350, 200);

        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();

    }
}
