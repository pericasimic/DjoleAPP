package djoleapp.controller.event.buildingevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.buildinggui.AddIndependentPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class AddIndependentEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        AddIndependentPane aip = new AddIndependentPane();
        Controller.getInstance().setAddIndependentPane(aip);
        Scene scena = new Scene(aip, Constants.SCENE_WIDTH_TEMP, Constants.SCENE_HEIGHT_TEMP);
        Controller.getInstance().getPrimaryStage().setScene(scena);

    }


}
