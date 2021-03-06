package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.IndependentSection;
import djoleapp.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*ListIndependentSectionsPane*/
public class RemoveIndSectionEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        removeIndSectionEvent();
    }
    
    public void removeIndSectionEvent(){
        IndependentSection is = Controller.getInstance().getListIndependentSectionsPane().getTableIndependent().getSelectionModel().getSelectedItem();
        Factory.getFacade().removeIndSection(is);
    }
    
}
