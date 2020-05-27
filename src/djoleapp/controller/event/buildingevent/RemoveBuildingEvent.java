package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.maingui.buildinggui.ListBuildingsPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class RemoveBuildingEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        removeBuildingEvent();
    }

    public void removeBuildingEvent() {

        ListBuildingsPane lbp = Controller.getInstance().getListBuildingsPane();
        ResidentialCommunity rc = lbp.getTableBuildings().getSelectionModel().getSelectedItem();
        if(!Factory.getFacade().removeBuilding(rc)){
            return;
        }
        
        Message.info(Alert.AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.SUCCESS_DELETE);
        lbp.reload();

    }

}
