package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.facade.Facade;
import djoleapp.business.model.Flat;
import djoleapp.business.model.Garage;
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

        ResidentialCommunity rc = asp.getBuildingsBox().getValue();
        String section = asp.getSectionsBox().getValue();
        String number = asp.getNumberFld().getText();
        double area = Double.valueOf(asp.getAreaFld().getText());
        String note = asp.getNoteFld().getText();
        List<SeparateSection> sectionsList = Controller.getInstance().getTemporaryList().getSeparateSections();

        if (rc == null || section.isEmpty() || section == null || number.isEmpty() || number == null || area == 0.0) {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            return;
        }

        if (section.equals(Constants.FLAT)) {
            SeparateSection ss = new Flat(sectionsList.size() + 1, rc, number, area, note);
            ss.setResidentialCommunity(asp.getBuildingsBox().getValue());
            asp.getBuildingsBox().getValue().getListSeparationSection().add(ss);
            if (asp.getOwnerBox().getValue() != null) {
                ss.setOccupant(asp.getOwnerBox().getValue());
            }
            Controller.getInstance().getTemporaryList().getSeparateSections().add(ss);
            
        }

        if (section.equals(Constants.GARAGE)) {
            SeparateSection ss = new Garage(sectionsList.size() + 1, rc, number, area, note);
            ss.setResidentialCommunity(asp.getBuildingsBox().getValue());
            asp.getBuildingsBox().getValue().getListSeparationSection().add(ss);
            if (asp.getOwnerBox().getValue() != null) {
                ss.setOccupant(asp.getOwnerBox().getValue());
            }
            Controller.getInstance().getTemporaryList().getSeparateSections().add(ss);
        }

        Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_NEW_SECTION);

        MainPane mp = new MainPane(Controller.getInstance().getListSeparateSectionsPane());
        Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
        Controller.getInstance().getListSeparateSectionsPane().reload(asp.getBuildingsBox().getValue().getListSeparationSection());
        Controller.getInstance().getTemporaryStage().close();

    }

}
