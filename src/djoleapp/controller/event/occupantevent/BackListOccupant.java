package djoleapp.controller.event.occupantevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.occupantgui.ListOccupantsPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class BackListOccupant implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        backListOccupant();

    }

    public void backListOccupant() {

        ListOccupantsPane lp = Controller.getInstance().getListOccupantsPane();
        MainPane mp = new MainPane(lp);
        Scene scene = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scene);
    }
}
