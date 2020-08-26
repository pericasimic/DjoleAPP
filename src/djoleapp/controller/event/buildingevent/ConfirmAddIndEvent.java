package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.gui.maingui.buildinggui.AddIndependentPane;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ConfirmAddIndEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        ResidentialCommunity rc = Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue();
        AddIndependentPane aip = Controller.getInstance().getAddIndependentPane();
        Factory.getFacade().addIndSection(aip.getNameFld().getText(), aip.getNoteFld().getText(), aip.getOwnerBox().getValue(), aip.getPricePerMonth().getText(), rc );
        

    }

}
