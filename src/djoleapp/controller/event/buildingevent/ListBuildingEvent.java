package djoleapp.controller.event.buildingevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.ListBuildingsPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class ListBuildingEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        ListBuildingsPane lup = new ListBuildingsPane();
        Controller.getInstance().setListBuildingsPane(lup);
        MainPane mp = new MainPane(lup);
        Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }
    
}
