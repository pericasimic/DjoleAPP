package djoleapp.controller.event.buildingevent;

import djoleapp.business.model.BankAccount;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.maingui.buildinggui.BankDetailsBildingPane;
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
        List<BankAccount> list = bdbp.getBuildingsBox().getValue().getBankAccounts();

        String bankName = bdbp.getNameBankFld().getText();
        String numAccount = bdbp.getNumAccountFld().getText();

        if (bankName.isEmpty() || bankName == null || numAccount.isEmpty() || numAccount == null) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            clearText();
            return;
        }

        BankAccount ba = new BankAccount(list.size() + 1, bankName, numAccount);
        list.add(ba);
        bdbp.reloadBankAccountTable(list);
        clearText();

    }
    
    private void clearText(){
        Controller.getInstance().getBankDetailsBildingPane().getNameBankFld().setText("");
        Controller.getInstance().getBankDetailsBildingPane().getNumAccountFld().setText("");
    }
    
}
