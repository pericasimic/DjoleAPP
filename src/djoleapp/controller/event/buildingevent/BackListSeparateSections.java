package djoleapp.controller.event.buildingevent;

import djoleapp.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BackListSeparateSections implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        backListSeparateSections();
    }
    
    public void backListSeparateSections(){
        Controller.getInstance().getManagerEvent().getAddSectionEvent().setScene();
        Controller.getInstance().getTemporaryStage().close();
    }
    
}
