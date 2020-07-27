package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.Flat;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.business.model.SeparateSection;
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
//        ResidentialCommunity rc = thbbp.getBuildingsBox().getValue();
        Occupant o = odbp.getOccupantsBox().getValue();
        SeparateSection ss = odbp.getSections().getValue();
        
//        if(Factory.getFacade().chackExistOccupantBuilding(rc, o)){
//            return;
//        };

        if(ss instanceof Flat){
            ((Flat) ss).getListOccupants().add(o);           
        }
        
        o.setIsAdd(true);
        odbp.reloadBox();
//        odbp.reload(rc.getListOccupants());
        
        
    }

}
