package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.business.model.CommonSection;
import djoleapp.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*ListCommonSectionPane*/
public class RemoveCommonEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        removeCommonEvent();
    }
    
    public void removeCommonEvent(){
        CommonSection cs = Controller.getInstance().getListCommonSectionPane().getTableCommon().getSelectionModel().getSelectedItem();
        Factory.getFacade().removeCommonSection(cs);
    }

}
