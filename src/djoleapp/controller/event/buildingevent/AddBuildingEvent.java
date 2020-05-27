package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.maingui.buildinggui.ListBuildingsPane;
import java.util.List;
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
        List<ResidentialCommunity> list = Controller.getInstance().getTemporaryList().getResidentialCommunitys();

        if (Factory.getFacade().checkAddBuildingFieldsEmpty(name, idNumber, taxNumber, mail)) {
            lp.clearAllFields();
            return;
        }

        if (Factory.getFacade().checkAddBuildingFieldExist(name, idNumber, taxNumber, mail)) {
            lp.clearAllFields();
            return;
        }

        ResidentialCommunity rc = new ResidentialCommunity(name, idNumber, taxNumber, mail);
        Controller.getInstance().getTemporaryList().getResidentialCommunitys().add(rc);
        Message.info(Alert.AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_BUILDING);
        lp.clearAllFields();
        lp.reload();
    }

}
