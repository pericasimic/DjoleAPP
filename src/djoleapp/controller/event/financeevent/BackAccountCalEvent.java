package djoleapp.controller.event.financeevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class BackAccountCalEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        backAccountCalEvent();
    }

    public void backAccountCalEvent() {
        MainPane mp = new MainPane(Controller.getInstance().getSelectOcupantPane());
        Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }

}
