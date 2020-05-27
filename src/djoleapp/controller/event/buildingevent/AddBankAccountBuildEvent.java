package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.BankAccount;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.maingui.buildinggui.BankDetailsBildingPane;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AddBankAccountBuildEvent implements EventHandler<ActionEvent> {
    
    @Override
    public void handle(ActionEvent event) {
        addBankAccountEvent();
    }
    
    public void addBankAccountEvent() {
        BankDetailsBildingPane bdbp = Controller.getInstance().getBankDetailsBildingPane();
        TopHBoxBuildingPane thbbp = Controller.getInstance().getTopHBoxBuildingPane();
        List<BankAccount> list = thbbp.getBuildingsBox().getValue().getBankAccounts();
        
        String bankName = bdbp.getNameBankFld().getText();
        Controller.getInstance().getBankDetailsBildingPane().getNameBankFld().setText("");
        String numAccount = bdbp.getNumAccountFld().getText();
        Controller.getInstance().getBankDetailsBildingPane().getNumAccountFld().setText("");
        if(!Factory.getFacade().checkBankAccount(bankName, numAccount)){
            return;
        }
        BankAccount ba = new BankAccount(bankName, numAccount);
        list.add(ba);
        bdbp.reloadBankAccountTable(list);
        Message.info(Alert.AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_BANK_ACCOUNT_SUCCESS);
    }
    
}
