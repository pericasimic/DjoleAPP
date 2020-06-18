package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.maingui.buildinggui.AddSeparatePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ConfirmAddSeparateEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        confirmAddSeparateEvent();
    }

    public void confirmAddSeparateEvent() {

        AddSeparatePane asp = Controller.getInstance().getAddSeparatePane();

        ResidentialCommunity rc = Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue();
        String section = asp.getSectionsBox().getValue();
        String number = asp.getNumberFld().getText();
        String note = asp.getNoteFld().getText();
        String area = asp.getAreaFld().getText();
        Occupant owner = asp.getOwnerBox().getValue();

        if (!Factory.getFacade().addSeparateSection(true, rc, section, number, area, note, owner)) {
            return;
        }
        Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent().showSelectBuildTableEvent();
    }

}
