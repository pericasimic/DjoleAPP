package djoleapp.controller.event.adminevent;

import djoleapp.business.Factory;
import djoleapp.business.model.Administrator;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.LoginPane;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;

public class AddAdminEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        addAdminEvent();
    }

    public void addAdminEvent() {
        String username = Controller.getInstance().getAddAdminPane().getAddUsernameFld().getText();
        Controller.getInstance().getAddAdminPane().getAddUsernameFld().setText(null);
        String password = Controller.getInstance().getAddAdminPane().getAddPasswordFld().getText();
        Controller.getInstance().getAddAdminPane().getAddPasswordFld().setText(null);
        String conPass = Controller.getInstance().getAddAdminPane().getConfirmPasswordFld().getText();
        Controller.getInstance().getAddAdminPane().getConfirmPasswordFld().setText(null);
        
        if (username == null || password == null || conPass == null || username.isEmpty() || password.isEmpty() || conPass.isEmpty()) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            return;
        }
        if(username.equalsIgnoreCase(Constants.ADMIN)){
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ADMIN_DENY);
            return;
        }
        if (!password.equals(conPass)) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_PASSWORD_NOT_SAME);
            return;
        }
        
        Administrator a = new Administrator(username, password);
        List<Administrator>list = Factory.getStorage().loadAdmin();
        list.add(a);
        Factory.getStorage().writeAdmin(list);
        Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_ADMIN);
        
        LoginPane lp = new LoginPane();
        Controller.getInstance().setLoginPane(lp);
        Scene scena = new Scene(lp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }

}
