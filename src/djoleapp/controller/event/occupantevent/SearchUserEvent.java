package djoleapp.controller.event.occupantevent;

import djoleapp.business.Factory;
import djoleapp.business.facade.Facade;
import djoleapp.controller.Controller;
import djoleapp.gui.maingui.occupantgui.ListOccupantsPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SearchUserEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        searchUserEvent();
    }

    public void searchUserEvent() {
        ListOccupantsPane lop = Controller.getInstance().getListOccupantsPane();

        lop.reloadTable(Factory.getFacade().searchUserList(lop.getSearchOccupantFld().getText()));
    }

}
