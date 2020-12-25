package djoleapp.controller.event.buildingevent;

import djoleapp.DjoleAPP;
import djoleapp.business.model.CommonSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.buildinggui.DetailsCommonPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/*ListCommonSectionPane*/
public class DetailsCommonSectionEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        
    }

    public void detailsCommonEvent(CommonSection section) {
        DetailsCommonPane dcp = new DetailsCommonPane(section);
        Controller.getInstance().setDetailsCommonPane(dcp);
        Scene scena = new Scene(dcp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
        scena.getStylesheets().add(DjoleAPP.class.getResource(Constants.STYLE_PATH).toExternalForm());
    }
    
}
