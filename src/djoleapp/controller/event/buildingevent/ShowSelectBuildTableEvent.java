package djoleapp.controller.event.buildingevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.BankDetailsBildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class ShowSelectBuildTableEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        showSelectBuildTableEvent();
    }

    public void showSelectBuildTableEvent() {

        BankDetailsBildingPane bdbp = Controller.getInstance().getBankDetailsBildingPane();

        if (bdbp.getSelectItemBox().getValue().equals(Constants.BANK_ACCOUNT)) {
            BankDetailsBildingPane bdbp1 = new BankDetailsBildingPane(bdbp.getBuildingsBox().getValue().getBankAccounts());
            bdbp1.getBuildingsBox().setValue(bdbp.getBuildingsBox().getValue());
            Controller.getInstance().setBankDetailsBildingPane(bdbp1);
            MainPane mp = new MainPane(bdbp1);
            Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
            Controller.getInstance().getPrimaryStage().setScene(scena);
        }

    }

}
