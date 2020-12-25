package djoleapp.controller.event.buildingevent;

import djoleapp.DjoleAPP;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.buildinggui.EditIndependentPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/*ListIndependentSectionsPane*/
public class EditIndependentEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        editIndependentEvent();
    }
    public void editIndependentEvent(){
        EditIndependentPane eip = new EditIndependentPane(Controller.getInstance().getTemporaryIndependentSection());
        Controller.getInstance().setEditIndependentPane(eip);
        Scene scena = new Scene(eip, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
        scena.getStylesheets().add(DjoleAPP.class.getResource(Constants.STYLE_PATH).toExternalForm());
        Controller.getInstance().getPrimaryStage().setOnCloseRequest(Controller.getInstance().getManagerEvent().getCloseAppEvent());
    }
    
}
