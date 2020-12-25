package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.gui.maingui.buildinggui.AddIndependentPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*AddIndependentPane*/
public class ConfirmAddIndEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        confirmAddIndEvent();
    }
    
    public void confirmAddIndEvent(){
        ResidentialCommunity rc = Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue();
        AddIndependentPane aip = Controller.getInstance().getAddIndependentPane();
        Factory.getFacade().addIndSection(aip.getNameFld().getText(), aip.getNoteFld().getText(), aip.getOwnerBox().getValue(), aip.getPricePerMonth().getText(), rc );
    }

}
