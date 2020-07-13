package djoleapp.controller.event.buildingevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.buildinggui.AddCommonPane;
import djoleapp.gui.maingui.buildinggui.AddIndependentPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class AddCommonEvent implements EventHandler<ActionEvent> {
    
    @Override
    public void handle(ActionEvent event) {
        AddCommonPane acp = new AddCommonPane();
        Controller.getInstance().setAddCommonPane(acp);
        Scene scena = new Scene(acp, Constants.SCENE_WIDTH_TEMP, Constants.SCENE_HEIGHT_TEMP);
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }
    
}
