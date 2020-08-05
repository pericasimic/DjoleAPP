package djoleapp.controller.event.occupantevent;

import djoleapp.business.model.Occupant;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.occupantgui.SelectOcupantPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class SelectOccupantEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
      
    }
    
    public void selectOccupantEvent(Occupant o){
        SelectOcupantPane sop = new SelectOcupantPane(o);
        Controller.getInstance().setSelectOcupantPane(sop);
        MainPane mp = new MainPane(sop);
        Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }
}
