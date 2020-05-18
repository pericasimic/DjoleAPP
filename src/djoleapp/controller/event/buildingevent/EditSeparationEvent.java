package djoleapp.controller.event.buildingevent;

import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.buildinggui.DetailsSeparatePane;
import djoleapp.gui.maingui.buildinggui.EditSeparatePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditSeparationEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        editSeparationEvent();
    }

    public void editSeparationEvent() {
        EditSeparatePane esp = new EditSeparatePane();
        Controller.getInstance().setEditSeparatePane(esp);
        Scene scena = new Scene(esp, Constants.SCENE_WIDTH_TEMP, Constants.SCENE_HEIGHT_TEMP);
        Stage stage = new Stage();
        stage.setScene(scena);
        stage.setTitle(Constants.SECTION_EDIT_TITLE);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

    }
}
