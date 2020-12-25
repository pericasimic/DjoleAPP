package djoleapp.controller.event.buildingevent;

import djoleapp.DjoleAPP;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.buildinggui.AddIndependentPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/*ListIndependentSectionsPane*/
public class AddIndependentEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        addIndependentEvent();
    }
    
    public void addIndependentEvent(){
        AddIndependentPane aip = new AddIndependentPane();
        Controller.getInstance().setAddIndependentPane(aip);
        Scene scena = new Scene(aip, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
        scena.getStylesheets().add(DjoleAPP.class.getResource(Constants.STYLE_PATH).toExternalForm());
    }


}
