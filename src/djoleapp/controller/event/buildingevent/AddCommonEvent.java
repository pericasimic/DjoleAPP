package djoleapp.controller.event.buildingevent;

import djoleapp.DjoleAPP;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.buildinggui.AddCommonPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/*ListCommonSectionPane*/
public class AddCommonEvent implements EventHandler<ActionEvent> {
    
    @Override
    public void handle(ActionEvent event) {
        addCommonEvent();
    }
    
    public void addCommonEvent(){
        AddCommonPane acp = new AddCommonPane();
        Controller.getInstance().setAddCommonPane(acp);
        Scene scena = new Scene(acp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
        scena.getStylesheets().add(DjoleAPP.class.getResource(Constants.STYLE_PATH).toExternalForm());
    }
    
}
