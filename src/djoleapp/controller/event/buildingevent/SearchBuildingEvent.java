package djoleapp.controller.event.buildingevent;

import djoleapp.business.Factory;
import djoleapp.controller.Controller;
import djoleapp.gui.maingui.buildinggui.ListBuildingsPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SearchBuildingEvent implements EventHandler<ActionEvent> {

    /*List Building Pane*/
    @Override
    public void handle(ActionEvent event) {
        searchBuildingEvent();
    }

    public void searchBuildingEvent() {
        ListBuildingsPane lbp = Controller.getInstance().getListBuildingsPane();
        String word = lbp.getSearchBuildingFld().getText();
        lbp.setIsSearch(true);
        lbp.setListBuildings(Factory.getFacade().searchBuidingList(word));
        lbp.reload();
        lbp.setIsSearch(false);

    }
}
