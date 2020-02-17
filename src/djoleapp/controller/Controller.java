package djoleapp.controller;

import djoleapp.business.storage.TemporaryList;
import djoleapp.controller.event.ManagerEvent;
import djoleapp.gui.LoginPane;
import djoleapp.gui.admingui.AddAdminPane;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.BankDetailsBildingPane;
import djoleapp.gui.maingui.buildinggui.ListBuildingsPane;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    
    private static Controller instance = null;
    private Stage primaryStage;
    private Scene loginScene;
    private LoginPane loginPane;
    private AddAdminPane addAdminPane;
    private MainPane mainPane;
    private ListBuildingsPane listBuildingsPane;
    private BankDetailsBildingPane bankDetailsBildingPane;
    private TemporaryList temporaryList;
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

    public AddAdminPane getAddAdminPane() {
        return addAdminPane;
    }

    public void setAddAdminPane(AddAdminPane addAdminPane) {
        this.addAdminPane = addAdminPane;
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

    public MainPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(MainPane mainPane) {
        this.mainPane = mainPane;
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

    public TemporaryList getTemporaryList() {
        return temporaryList;
    }

    public void setTemporaryList(TemporaryList temporaryList) {
        this.temporaryList = temporaryList;
    }

    public ListBuildingsPane getListBuildingsPane() {
        return listBuildingsPane;
    }

    public void setListBuildingsPane(ListBuildingsPane listBuildingsPane) {
        this.listBuildingsPane = listBuildingsPane;
    }

    public BankDetailsBildingPane getBankDetailsBildingPane() {
        return bankDetailsBildingPane;
    }

    public void setBankDetailsBildingPane(BankDetailsBildingPane bankDetailsBildingPane) {
        this.bankDetailsBildingPane = bankDetailsBildingPane;
    }

    
    
    

}
