package djoleapp.controller.event.buildingevent;

import djoleapp.business.model.CommonSection;
import djoleapp.business.model.IndependentSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.DetailsCommonPane;
import djoleapp.gui.maingui.buildinggui.DetailsIndependentPane;
import djoleapp.gui.maingui.buildinggui.ListCommonSectionPane;
import djoleapp.gui.maingui.buildinggui.ListIndependentSectionsPane;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class DetailsCommonSectionEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        TopHBoxBuildingPane thbbp = Controller.getInstance().getTopHBoxBuildingPane();
        ListCommonSectionPane lcsp = new ListCommonSectionPane(thbbp.getBuildingsBox().getValue().getListCommonSections(), thbbp);
        Controller.getInstance().setListCommonSectionPane(lcsp);
        MainPane mp = new MainPane(lcsp);
        Scene scene = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scene);
    }

    public void detailsCommonEvent(CommonSection section) {
        DetailsCommonPane dcp = new DetailsCommonPane(section);
        Controller.getInstance().setDetailsCommonPane(dcp);
        Scene scena = new Scene(dcp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }
    
}
