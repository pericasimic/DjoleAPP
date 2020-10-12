package djoleapp;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.LoginPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author perica.simic
 */
public class DjoleAPP extends Application {

    @Override
    public void start(Stage primaryStage) {
        Controller.getInstance().setPrimaryStage(primaryStage);
        LoginPane root = new LoginPane();
        Controller.getInstance().setLoginPane(root);
        Scene scene = new Scene(root, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        scene.getStylesheets().add(DjoleAPP.class.getResource(Constants.STYLE_PATH).toExternalForm());
        Controller.getInstance().setLoginScene(scene);
        primaryStage.setScene(scene);
        primaryStage.setTitle(Constants.PRIMARY_STAGE_TITLE);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }

}
