/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djoleapp;

import djoleapp.business.model.Flat;
import djoleapp.business.model.ParkingBox;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.LoginPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
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
