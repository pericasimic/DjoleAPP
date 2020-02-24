package djoleapp.controller.event.occupantevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.occupantgui.AddOccupantPane;
import djoleapp.gui.maingui.occupantgui.ListOccupantsPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class AddOccupantEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        addOccupantEvent();
    }
    
    public void addOccupantEvent(){
        AddOccupantPane aop = new AddOccupantPane();
        Controller.getInstance().setAddOccupantPane(aop);
        MainPane mp = new MainPane(aop);
        Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }
    
}
