package djoleapp.controller.event.buildingevent;

import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.buildinggui.DetailsSeparatePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DetailsSeparateEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        
    }
    
    public void detailsSeparateEvent(SeparateSection section){
        Controller.getInstance().setTemporarySeparateSection(section);
        DetailsSeparatePane dsp = new DetailsSeparatePane(section);
        Controller.getInstance().setDetailsSeparatePane(dsp);
        Scene scena = new Scene(dsp, Constants.SCENE_WIDTH_TEMP, Constants.SCENE_HEIGHT_TEMP);
        Stage stage = new Stage();
        Controller.getInstance().setTemporaryStage(stage);
        stage.setScene(scena);
        stage.setTitle(Constants.SEPARATE_SECTIONS);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }
    
}
