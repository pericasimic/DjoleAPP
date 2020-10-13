package djoleapp.controller.event.adminevent;

import djoleapp.DjoleAPP;
import djoleapp.business.Factory;
import djoleapp.business.storage.TemporaryList;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.constant.CssId;
import djoleapp.gui.maingui.MainPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

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

        if (!Factory.getFacade().loginAdminCheck(checkUsername, checkPassword)) {
            return;
        }

        TemporaryList temporaryList = new TemporaryList();
        Controller.getInstance().setTemporaryList(temporaryList);

        MainPane gp = new MainPane();
        gp.getStyleClass().add(CssId.MAIN_PANE);
        Controller.getInstance().setMainPane(gp);
        Scene scena = new Scene(gp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        scena.getStylesheets().add(DjoleAPP.class.getResource(Constants.STYLE_PATH).toExternalForm());
        Controller.getInstance().getPrimaryStage().setScene(scena);

    }

}
