package djoleapp.controller.event.buildingevent;

import djoleapp.DjoleAPP;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.buildinggui.DetailsSeparatePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/*ListSeparateSectionsPane*/
public class DetailsSeparateEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

    }

    public void detailsSeparateEvent(SeparateSection section) {
        DetailsSeparatePane dsp = new DetailsSeparatePane(section);
        Controller.getInstance().setDetailsSeparatePane(dsp);
        Scene scena = new Scene(dsp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        scena.getStylesheets().add(DjoleAPP.class.getResource(Constants.STYLE_PATH).toExternalForm());
        Controller.getInstance().getPrimaryStage().setScene(scena);
        Controller.getInstance().getPrimaryStage().setOnCloseRequest(Controller.getInstance().getManagerEvent().getCloseAppEvent());
    }

}
