package djoleapp.controller.event.buildingevent;

import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.maingui.buildinggui.ListBuildingsPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class AddBuildingEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        addBuildingEvent();
    }

    public void addBuildingEvent() {
        
        ListBuildingsPane lp = Controller.getInstance().getListBuildingsPane();
        
        String name = lp.getNameBuildingFld().getText();
        String idNumber = lp.getIdNumBuildingFld().getText();
        String taxNumber = lp.getTidNumBuildingFld().getText();
        String mail = lp.getMailBuildingFld().getText();

        if (name.isEmpty() || name == null || idNumber.isEmpty() || idNumber == null || taxNumber.isEmpty() || taxNumber == null || mail.isEmpty() || mail == null) {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            lp.clearAllFields();
            return;
        }

        try {
            int id = Controller.getInstance().getTemporaryList().getResidentialCommunitys().size() + 1;
            ResidentialCommunity rc = new ResidentialCommunity(id, name, idNumber, taxNumber, mail);
            Controller.getInstance().getTemporaryList().getResidentialCommunitys().add(rc);
            Message.info(Alert.AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_BUILDING);
            lp.clearAllFields();
            lp.reload();
        } catch (Exception e) {
            Message.info(Alert.AlertType.ERROR, Constants.ALERT_WARNING_DIALOG, Constants.NOT_ADD_BUILDING);
        }
    }

}
