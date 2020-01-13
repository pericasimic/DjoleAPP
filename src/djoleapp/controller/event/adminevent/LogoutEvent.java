package djoleapp.controller.event.adminevent;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class LogoutEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        logoutEvent();
    }
    
    public void logoutEvent(){
        Platform.exit();
    }
    
}
