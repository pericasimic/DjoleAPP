package djoleapp.controller.event.buildingevent;

import djoleapp.controller.Controller;
import djoleapp.gui.maingui.buildinggui.AddSeparatePane;
import djoleapp.gui.maingui.buildinggui.EditSeparatePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ReloadListOwnerBuildingEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        reloadListOwnerBuilding();
    }

    public void reloadListOwnerBuilding() {
        AddSeparatePane asp = Controller.getInstance().getAddSeparatePane();
        EditSeparatePane esp = Controller.getInstance().getEditSeparatePane();

        if (asp != null) {
            asp.reloadOwnersBox(asp.getBuildingsBox().getValue().getListOccupants());
        }
        if(esp !=null){
            esp.reloadOwnersBox(esp.getBuildingsBox().getValue().getListOccupants());
        }
    }

}
