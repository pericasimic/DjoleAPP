package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.gui.maingui.buildinggui.EditIndependentPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*EditIndependentPane*/
public class ConfirmEditIndependentEvent implements EventHandler<ActionEvent>{
    
    @Override
    public void handle(ActionEvent event) {
        confirmEditIndependentEvent();
    }
    
    public void confirmEditIndependentEvent(){
        ResidentialCommunity rc = Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue();
        EditIndependentPane eip = Controller.getInstance().getEditIndependentPane();
        Factory.getFacade().editIndSection(eip.getNameFld().getText(), eip.getNoteFld().getText(), eip.getOwners().getValue(), eip.getPricePerMonth().getText(), rc );
     
    }
}
