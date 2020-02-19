package djoleapp.controller.event.buildingevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.BankDetailsBildingPane;
import djoleapp.gui.maingui.buildinggui.BuildingDetailsPane;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;


public class BankDetailsBuildingEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        
        TopHBoxBuildingPane thbbp = new TopHBoxBuildingPane();
        Controller.getInstance().setTopHBoxBuildingPane(thbbp);
        BuildingDetailsPane bdp = new BuildingDetailsPane(thbbp);
        Controller.getInstance().setBuildingDetailsPane(bdp);
        MainPane mp = new MainPane(bdp);
        Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
        
    }
    
    
    
}
