package djoleapp.controller.event.occupantevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.occupantgui.EditOccupantPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;


public class EditOccupantEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        editOccupantEvent();
    }
    
    public void editOccupantEvent(){
        EditOccupantPane eop = new EditOccupantPane(Controller.getInstance().getTemporaryOccupant());
        Controller.getInstance().setEditOccupantPane(eop);
        MainPane mp = new MainPane(eop);
        Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }
}
