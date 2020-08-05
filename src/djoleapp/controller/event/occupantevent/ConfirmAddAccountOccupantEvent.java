package djoleapp.controller.event.occupantevent;

import djoleapp.business.Factory;
import djoleapp.business.model.BankAccount;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.occupantgui.AddAccountOccupantPane;
import djoleapp.gui.maingui.occupantgui.SelectOcupantPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class ConfirmAddAccountOccupantEvent implements EventHandler<ActionEvent> {
    
    @Override
    public void handle(ActionEvent event) {
        confirmAddAccountOccupantEvent();
    }
    
    public void confirmAddAccountOccupantEvent() {
        
        AddAccountOccupantPane aaop = Controller.getInstance().getAddAccountOccupantPane();
        
        if (!Factory.getFacade().checkBankAccount(aaop.getNameOfBankFld().getText(), aaop.getNumberFld().getText())) {
            Controller.getInstance().getAddAccountOccupantPane().getNameOfBankFld().setText(Constants.EMPTY_STRING);
            Controller.getInstance().getAddAccountOccupantPane().getNumberFld().setText(Constants.EMPTY_STRING);
            return;
        }
        
        if (!Factory.getFacade().createBankAccountOccupant(aaop.getNameOfBankFld().getText(), aaop.getNumberFld().getText())) {
            return;
        }
        
        Controller.getInstance().getManagerEvent().getSelectOccupantEvent().selectOccupantEvent(Controller.getInstance().getTemporaryOccupant());
    }
    
}
