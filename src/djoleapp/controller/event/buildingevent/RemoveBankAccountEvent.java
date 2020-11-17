package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.BankAccount;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.maingui.buildinggui.BankDetailsBildingPane;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;

/*BankDetailsBildingPane*/
public class RemoveBankAccountEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        removeBankAccountEvent();
    }

    public void removeBankAccountEvent() {
        TopHBoxBuildingPane thbbp = Controller.getInstance().getTopHBoxBuildingPane();
        BankDetailsBildingPane bdbp = Controller.getInstance().getBankDetailsBildingPane();
        BankAccount ba = bdbp.getBankAccountTable().getSelectionModel().getSelectedItem();

        if(!Factory.getFacade().removeBankAccount(ba, thbbp.getBuildingsBox().getValue())){
            return;
        }
        
        Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.SUCCESS_DELETE);
        bdbp.reloadBankAccountTable(thbbp.getBuildingsBox().getValue().getBankAccounts());
        
    }

}
