package djoleapp.controller.event.financeevent;

import djoleapp.business.Factory;
import djoleapp.business.facade.Facade;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.finance.AccountCalculationPane;
import djoleapp.gui.maingui.finance.EditCalculationPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;

public class ChangeCalculationEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        changeCalculationEvent();
    }

    public void changeCalculationEvent() {
        EditCalculationPane ecp = Controller.getInstance().getEditCalculationPane();
        double value = 0;
        try {
            value = Double.valueOf(ecp.getSumFld().getText());
        } catch (NumberFormatException nfe) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.BAD_FORMAT_AREA);
            return;
        }
        Factory.getFacade().changeCalculationSum(Controller.getInstance().getTemporaryAccountCalculation(), value);
        AccountCalculationPane ac = new AccountCalculationPane(Controller.getInstance().getTemporaryOccupant());
        Controller.getInstance().setAccountCalculationPane(ac);
        MainPane mp = new MainPane(ac);
        Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }

}
