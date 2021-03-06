package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.gui.maingui.buildinggui.OccupantDetailsBuildingPane;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*OccupantDetailsBuildingPane*/
public class AddOccupantBuildingEvent implements EventHandler<ActionEvent> {
    
    @Override
    public void handle(ActionEvent event) {
        addOccupantBuildingEvent();
    }
    
    public void addOccupantBuildingEvent() {
        OccupantDetailsBuildingPane odbp = Controller.getInstance().getOccupantDetailsBuildingPane();
        TopHBoxBuildingPane thbbp = Controller.getInstance().getTopHBoxBuildingPane();
        ResidentialCommunity rr = thbbp.getBuildingsBox().getValue();
        Occupant o = odbp.getOccupantsBox().getValue();
        SeparateSection ss = odbp.getSections().getValue();

//        if(Factory.getFacade().chackExistOccupantBuilding(rr, o)){
//            return;
//        }
        
        Factory.getFacade().addOccupantBuilding(rr, o, ss);
        
        odbp.reloadBox();
        odbp.reload(rr.getListOccupants());
        
    }
    
}
