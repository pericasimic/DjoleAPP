package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.gui.maingui.buildinggui.ListSeparateSectionsPane;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*ListSeparateSectionsPane*/
public class RemoveSeparateSectionEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        removeSeparateSectionEvent();
    }
    
    public void removeSeparateSectionEvent(){
        
        ListSeparateSectionsPane lssp = Controller.getInstance().getListSeparateSectionsPane();
        TopHBoxBuildingPane thbbp = Controller.getInstance().getTopHBoxBuildingPane();
        
        SeparateSection section = lssp.getTableSection().getSelectionModel().getSelectedItem();
        ResidentialCommunity residentialCommunity =thbbp.getBuildingsBox().getValue();
        
        Factory.getFacade().removeSeparateSection(section, residentialCommunity);
        lssp.reload(residentialCommunity.getListSeparationSection());
        
    }
    
}
