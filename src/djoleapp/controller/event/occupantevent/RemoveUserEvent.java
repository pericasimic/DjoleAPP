package djoleapp.controller.event.occupantevent;

import djoleapp.business.Factory;
import djoleapp.business.model.Occupant;
import djoleapp.controller.Controller;
import djoleapp.gui.maingui.occupantgui.ListOccupantsPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RemoveUserEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        ListOccupantsPane lop = Controller.getInstance().getListOccupantsPane();
        Occupant occupant = lop.getTableOccupant().getSelectionModel().getSelectedItem();
        
        Factory.getFacade().removeOccupant(occupant);
        lop.reloadTable(Controller.getInstance().getTemporaryList().getOccupants());
    }
    
    
}
