package djoleapp.controller.event.buildingevent;

import djoleapp.business.model.IndependentSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.DetailsIndependentPane;
import djoleapp.gui.maingui.buildinggui.ListIndependentSectionsPane;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class DetailsIndependentEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        TopHBoxBuildingPane thbbp = Controller.getInstance().getTopHBoxBuildingPane();
        ListIndependentSectionsPane lisp = new ListIndependentSectionsPane(thbbp.getBuildingsBox().getValue().getListIndependentSections(), thbbp);
        Controller.getInstance().setListIndependentSectionsPane(lisp);
        MainPane mp = new MainPane(lisp);
        Scene scene = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scene);
    }

    public void detailsIndependentEvent(IndependentSection section) {
        DetailsIndependentPane dip = new DetailsIndependentPane(section);
        Controller.getInstance().setDetailsIndependentPane(dip);
        Scene scena = new Scene(dip, Constants.SCENE_WIDTH_TEMP, Constants.SCENE_HEIGHT_TEMP);
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }

}
