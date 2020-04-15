package djoleapp.controller.event.buildingevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.buildinggui.AddSeparatePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddSectionEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        addSectionEvent();
    }
    
    public void addSectionEvent(){
        AddSeparatePane asp = new AddSeparatePane();
        Controller.getInstance().setAddSeparatePane(asp);
        Scene scena = new Scene(asp, Constants.SCENE_WIDTH_TEMP, Constants.SCENE_HEIGHT_TEMP);
        Stage stage = new Stage();
        Controller.getInstance().setTemporaryStage(stage);
        stage.setScene(scena);
        stage.setTitle(Constants.SEPARATE_SECTIONS);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }
    
}
