package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.controller.Controller;
import djoleapp.gui.maingui.buildinggui.AddCommonPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ConfirmAddCommonEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        AddCommonPane acp = Controller.getInstance().getAddCommonPane();
        Factory.getFacade().addCommonSection(acp.getNameFld().getText(), acp.getNoteFld().getText(), acp.getPricePerMonth().getText());
    }
    
}
