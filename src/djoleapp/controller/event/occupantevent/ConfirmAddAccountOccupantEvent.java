package djoleapp.controller.event.occupantevent;

import djoleapp.business.model.BankAccount;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.occupantgui.AddAccountOccupantPane;
import djoleapp.gui.maingui.occupantgui.SelectOcupantPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ConfirmAddAccountOccupantEvent implements EventHandler<ActionEvent> {
    
    @Override
    public void handle(ActionEvent event) {
        confirmAddAccountOccupantEvent();
    }
    
    public void confirmAddAccountOccupantEvent() {
        
        AddAccountOccupantPane aaop = Controller.getInstance().getAddAccountOccupantPane();
        
        String bankName = aaop.getNameOfBankFld().getText();
        Controller.getInstance().getAddAccountOccupantPane().getNameOfBankFld().setText(Constants.EMPTY_STRING);
        String number = aaop.getNumberFld().getText();
        Controller.getInstance().getAddAccountOccupantPane().getNumberFld().setText(Constants.EMPTY_STRING);
        
        BankAccount ba = new BankAccount(Controller.getInstance().getTemporaryList().getBankAccounts().size() + 1, bankName, number);
        Controller.getInstance().getTemporaryList().getBankAccounts().add(ba);
        Controller.getInstance().getTemporaryOccupant().getBankAccounts().add(ba);
        Controller.getInstance().getTemporaryStage().close();
        Controller.getInstance().getSelectOcupantPane().reloadList();
    }
    
}
