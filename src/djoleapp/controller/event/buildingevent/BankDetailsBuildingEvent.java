package djoleapp.controller.event.buildingevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.BankDetailsBildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;


public class BankDetailsBuildingEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        
        BankDetailsBildingPane lbabp = new BankDetailsBildingPane();
        Controller.getInstance().setBankDetailsBildingPane(lbabp);
        MainPane mp = new MainPane(lbabp);
        Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
        
    }
    
    
    
}
