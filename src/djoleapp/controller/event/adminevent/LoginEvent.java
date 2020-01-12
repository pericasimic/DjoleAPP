/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djoleapp.controller.event.adminevent;

import djoleapp.business.Factory;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author perica.simic
 */
public class LoginEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        loginEvent();
    }

    public void loginEvent() {

        String checkUsername = Controller.getInstance().getLoginPane().getUsernameFld().getText();
        Controller.getInstance().getLoginPane().getUsernameFld().setText(null);

        String checkPassword = Controller.getInstance().getLoginPane().getPasswordFld().getText();
        Controller.getInstance().getLoginPane().getUsernameFld().setText(null);

        if (checkUsername == null || checkPassword == null || checkUsername.isEmpty() || checkPassword.isEmpty()) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            return;
        }

        if (checkUsername.equals(Constants.ADMIN) && checkPassword.equals(Constants.ADMIN) && Factory.getStorage().loadAdmin().size() == 1) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, "1");
            return;
        }
        
        Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, "2");
    }


}
