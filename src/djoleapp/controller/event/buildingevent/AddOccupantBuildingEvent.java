package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.gui.maingui.buildinggui.OccupantDetailsBuildingPane;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AddOccupantBuildingEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        addOccupantBuildingEvent();
    }

    public void addOccupantBuildingEvent() {
        OccupantDetailsBuildingPane odbp = Controller.getInstance().getOccupantDetailsBuildingPane();
        TopHBoxBuildingPane thbbp = Controller.getInstance().getTopHBoxBuildingPane();
        ResidentialCommunity rc = thbbp.getBuildingsBox().getValue();
        Occupant o = odbp.getOccupantsBox().getValue();
        
        if(!Factory.getFacade().chackExistOccupantBuilding(rc, o)){
            
        };
        
        rc.getListOccupants().add(o);
        o.setIsAdd(true);
        o.getResidentials().add(rc);
        odbp.reloadBox();
        odbp.reload(rc.getListOccupants());
        
    }

}
