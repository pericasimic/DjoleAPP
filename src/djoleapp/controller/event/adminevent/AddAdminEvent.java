package djoleapp.controller.event.adminevent;

import djoleapp.business.Factory;
import djoleapp.business.model.Administrator;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

        if (!Factory.getFacade().checkAddAdmin(username, password, conPass)) {
            return;
        }

        Administrator a = new Administrator(username, password);
        List<Administrator> list = Factory.getStorage().loadAdmin();
        list.add(a);
        Factory.getStorage().writeAdmins(list);
        Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_ADMIN);

        Controller.getInstance().getPrimaryStage().setScene(Controller.getInstance().getLoginScene());
    }

}
