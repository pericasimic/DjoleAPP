package djoleapp.controller.event.buildingevent;

import djoleapp.DjoleAPP;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.buildinggui.AddSeparatePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/*ListSeparateSectionsPane*/
public class AddSectionEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        addSectionEvent();
    }

    public void addSectionEvent() {
        AddSeparatePane asp = new AddSeparatePane();
        Controller.getInstance().setAddSeparatePane(asp);
        Scene scena = new Scene(asp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        scena.getStylesheets().add(DjoleAPP.class.getResource(Constants.STYLE_PATH).toExternalForm());
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }

}
