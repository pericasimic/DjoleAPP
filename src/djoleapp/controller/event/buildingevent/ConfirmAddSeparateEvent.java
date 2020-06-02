package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.facade.Facade;
import djoleapp.business.model.Flat;
import djoleapp.business.model.Garage;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.AddSeparatePane;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

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
        Occupant owner = asp.getOwnerBox().getValue();
        if (asp.getAreaFld().getText().isEmpty() || asp.getAreaFld().getText() == null) {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            return;
        }

        double area = Double.valueOf(asp.getAreaFld().getText());

        if (!Factory.getFacade().addSeparateSection(rc, section, number, area, note, owner)) {
            return;
        }

    }

}
