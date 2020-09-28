package djoleapp.controller.event.financeevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.finance.EditCalculationPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class EditCalculationEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        editCalculationEvent();
    }
    
    public void editCalculationEvent(){
        EditCalculationPane ecp = new EditCalculationPane(Controller.getInstance().getTemporaryAccountCalculation());
        Controller.getInstance().setEditCalculationPane(ecp);
        Scene scena = new Scene(ecp, Constants.SCENE_WIDTH_TEMP, Constants.SCENE_HEIGHT_TEMP);
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }
    
}
