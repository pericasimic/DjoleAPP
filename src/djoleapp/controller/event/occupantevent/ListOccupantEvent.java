package djoleapp.controller.event.occupantevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.occupantgui.ListOccupantsPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class ListOccupantEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        ListOccupantsPane lop = new ListOccupantsPane();
        Controller.getInstance().setListOccupantsPane(lop);
        MainPane mp = new MainPane(lop);
        Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }

}
