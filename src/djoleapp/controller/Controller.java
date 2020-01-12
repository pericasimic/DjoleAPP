package djoleapp.controller;

import djoleapp.controller.event.ManagerEvent;
import djoleapp.gui.LoginPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    
    private static Controller instance = null;
    private Stage primaryStage;
    private Scene loginScene;
    private LoginPane loginPane;
    private final ManagerEvent managerEvent = new ManagerEvent();
    
    public Controller(){    
    }
    
    public static Controller getInstance(){
        
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public LoginPane getLoginPane() {
        return loginPane;
    }

    public void setLoginPane(LoginPane loginPane) {
        this.loginPane = loginPane;
    }

    public Scene getLoginScene() {
        return loginScene;
    }

    public void setLoginScene(Scene loginScene) {
        this.loginScene = loginScene;
    }

    public ManagerEvent getManagerEvent() {
        return managerEvent;
    }

}
