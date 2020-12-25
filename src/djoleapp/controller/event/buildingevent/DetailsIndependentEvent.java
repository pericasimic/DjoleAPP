package djoleapp.controller.event.buildingevent;

import djoleapp.DjoleAPP;
import djoleapp.business.model.IndependentSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.buildinggui.DetailsIndependentPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/*ListIndependentSectionsPane*/
public class DetailsIndependentEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        
    }

    public void detailsIndependentEvent(IndependentSection section) {
        DetailsIndependentPane dip = new DetailsIndependentPane(section);
        Controller.getInstance().setTemporaryIndependentSection(section);
        Controller.getInstance().setDetailsIndependentPane(dip);
        Scene scena = new Scene(dip, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        scena.getStylesheets().add(DjoleAPP.class.getResource(Constants.STYLE_PATH).toExternalForm());
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }

}
