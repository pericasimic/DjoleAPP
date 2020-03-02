package djoleapp.controller.event.occupantevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.occupantgui.AddAccountOccupantPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddAccountOccupantEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        addAccountOccupantEvent();
    }
    
    public void addAccountOccupantEvent(){
        AddAccountOccupantPane aaop = new AddAccountOccupantPane();
        Controller.getInstance().setAddAccountOccupantPane(aaop);
        Scene scena = new Scene(aaop, Constants.SCENE_WIDTH_TEMP, Constants.SCENE_HEIGHT_TEMP);
        Stage stage = new Stage();
        Controller.getInstance().setTemporaryStage(stage);
        stage.setScene(scena);
        stage.setTitle(Constants.ACCOUNTS);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }
    
}
