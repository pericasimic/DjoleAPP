package djoleapp.controller.event.occupantevent;

import djoleapp.business.Factory;
import djoleapp.business.facade.Facade;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.maingui.occupantgui.EditOccupantPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ConfirmChangeOccupantEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        confirmChangeOccupant();
    }

    public void confirmChangeOccupant() {

        EditOccupantPane eop = Controller.getInstance().getEditOccupantPane();

        if(Factory.getFacade().editOccupant(eop.getNameFld().getText(), eop.getLastNameFld().getText(),
                eop.getIdNumberFld().getText(), eop.getPhoneFld().getText(),
                eop.getMailFld().getText(), eop.getNoteFld().getText())){
            
            Message.info(Alert.AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.EDIT_OCCUPANT_SUCCESS);
            Controller.getInstance().getManagerEvent().getListOccupantEvent().listOccupantEvent();
            
        }

    }

}
