package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.gui.maingui.buildinggui.OccupantDetailsBuildingPane;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RemoveBuildingOccupantEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

        OccupantDetailsBuildingPane odbp = Controller.getInstance().getOccupantDetailsBuildingPane();
        TopHBoxBuildingPane thbbp = Controller.getInstance().getTopHBoxBuildingPane();

        ResidentialCommunity rc = thbbp.getBuildingsBox().getValue();
        Occupant o = odbp.getTableOccupant().getSelectionModel().getSelectedItem();

        Factory.getFacade().removeBuildingOccupant(rc, o);
        odbp.reload(rc.getListOccupants());

    }

}
