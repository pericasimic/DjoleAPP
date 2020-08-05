package djoleapp.controller.event.occupantevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.occupantgui.AddAccountOccupantPane;
import djoleapp.gui.maingui.occupantgui.SelectOcupantPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class BackAddAccountOccupantEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        backAddAccountOccupantEvent();
    }

    public void backAddAccountOccupantEvent() {

        SelectOcupantPane sop = Controller.getInstance().getSelectOcupantPane();
        MainPane mp = new MainPane(sop);
        Scene scene = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scene);
    }

}
