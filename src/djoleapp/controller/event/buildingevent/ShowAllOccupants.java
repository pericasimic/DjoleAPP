package djoleapp.controller.event.buildingevent;

import djoleapp.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ShowAllOccupants implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        showAllOccupant();
    }
    
    public void showAllOccupant(){
        Controller.getInstance().getOccupantDetailsBuildingPane().reloadBoxAll();
    }
    
}
