package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.controller.Controller;
import djoleapp.gui.maingui.buildinggui.AddIndependentPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ConfirmAddIndEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        AddIndependentPane aip = Controller.getInstance().getAddIndependentPane();
        Factory.getFacade().addIndSection(aip.getNameFld().getText(), aip.getNoteFld().getText(), aip.getOwnerBox().getValue(), aip.getPricePerMonth().getText());
        

    }

}
