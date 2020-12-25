package djoleapp.controller.event.buildingevent;

import djoleapp.DjoleAPP;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.buildinggui.EditSeparatePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/*DetailsSeparatePane*/
public class EditSeparationEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        editSeparationEvent();
    }

    public void editSeparationEvent() {
        EditSeparatePane esp = new EditSeparatePane();
        Controller.getInstance().setEditSeparatePane(esp);
        Scene scena = new Scene(esp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        scena.getStylesheets().add(DjoleAPP.class.getResource(Constants.STYLE_PATH).toExternalForm());
        Controller.getInstance().getPrimaryStage().setScene(scena);

    }

}
