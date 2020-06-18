package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.gui.maingui.buildinggui.EditSeparatePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ConfirmEditSeparateEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        EditSeparatePane esp = Controller.getInstance().getEditSeparatePane();
        
        ResidentialCommunity rc = esp.getBuildingsBox().getValue();
        String section = esp.getSectionFld().getText();
        String number = esp.getNumberFld().getText();
        String note = esp.getNoteFld().getText();
        String area = esp.getAreaFld().getText();
        Occupant owner = esp.getOwnerBox().getValue();

        if (!Factory.getFacade().addSeparateSection(false, rc, section, number, area, note, owner)) {
            return;
        }
        Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent().showSelectBuildTableEvent();
        
    }
    
}
