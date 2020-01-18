package djoleapp.controller.event.adminevent;

import djoleapp.business.Factory;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;


public class SaveEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        Controller.getInstance().getTemporaryList().saveTemporaryLists();
        Message.info(Alert.AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.SUCCESS_SAVE);
    }
    
    
    
}
