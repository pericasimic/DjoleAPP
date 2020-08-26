package djoleapp.controller.event.adminevent;

import djoleapp.business.Factory;
import djoleapp.business.storage.TemporaryList;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.admingui.AddAdminPane;
import djoleapp.gui.maingui.MainPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;

public class LoginEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        loginEvent();
    }

    public void loginEvent() {

        String checkUsername = Controller.getInstance().getLoginPane().getUsernameFld().getText();
        Controller.getInstance().getLoginPane().getUsernameFld().setText(null);

        String checkPassword = Controller.getInstance().getLoginPane().getPasswordFld().getText();
        Controller.getInstance().getLoginPane().getPasswordFld().setText(null);

        if (checkUsername == null || checkPassword == null || checkUsername.isEmpty() || checkPassword.isEmpty()) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            return;
        }

        if (checkUsername.equals(Constants.ADMIN) && checkPassword.equals(Constants.ADMIN) && Factory.getStorage().loadAdmin().size() == 1) {
            AddAdminPane aap = new AddAdminPane();
            Controller.getInstance().setAddAdminPane(aap);
            Scene scena = new Scene(aap, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
            Controller.getInstance().getPrimaryStage().setScene(scena);
            return;
        }
        if (checkUsername.equals(Constants.ADMIN) && checkPassword.equals(Constants.ADMIN) && Factory.getStorage().loadAdmin().size() != 1){
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ADMIN_EXISTS);
            return;
        }
        
        if(!Factory.getFacade().loginAdminCheck(checkUsername, checkPassword)){
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ADMIN_LOGIN_FAILD);
            return;
        }

        TemporaryList tl = new TemporaryList();
        Controller.getInstance().setTemporaryList(tl);
        
        MainPane gp = new MainPane();
        Controller.getInstance().setMainPane(gp);
        Scene scena = new Scene(gp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
        Factory.getFacade().createNewCalculations();

        }
        
    }
