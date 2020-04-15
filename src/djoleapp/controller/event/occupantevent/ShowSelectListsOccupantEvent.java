package djoleapp.controller.event.occupantevent;

import djoleapp.business.model.Occupant;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.occupantgui.SelectOcupantPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;


public class ShowSelectListsOccupantEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        showSelectListsOccupantEvent();
    }
    
    public void showSelectListsOccupantEvent(){
        SelectOcupantPane sop = Controller.getInstance().getSelectOcupantPane();
        Occupant o = Controller.getInstance().getTemporaryOccupant();
        String select = sop.getSelctBox().getValue();
        
        if(select.equals(Constants.SEPARATE_SECTIONS)){
           
        }
       
        if(select.equals(Constants.STATEMENTS)){
            
        }
        
        if(select.equals(Constants.ACCOUNTS)){
            
        }
    }
    
}
