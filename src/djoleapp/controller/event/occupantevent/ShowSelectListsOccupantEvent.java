package djoleapp.controller.event.occupantevent;

import djoleapp.business.Factory;
import djoleapp.business.model.Occupant;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.ListSeparateSectionsPane;
import djoleapp.gui.maingui.occupantgui.SelectOcupantPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

public class ShowSelectListsOccupantEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        showSelectListsOccupantEvent();
    }

    public void showSelectListsOccupantEvent() {
        SelectOcupantPane sop = Controller.getInstance().getSelectOcupantPane();
        Occupant o = Controller.getInstance().getTemporaryOccupant();
        String select = sop.getSelctBox().getValue();

        if (select.equals(Constants.SEPARATE_SECTIONS)) {
            ListSeparateSectionsPane lssp = new ListSeparateSectionsPane(Factory.getFacade().getSeparateSectionPerOccupant(o));
            Controller.getInstance().setListSeparateSectionsPane(lssp);
            MainPane mp = new MainPane(lssp);
            Scene scene = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
            Controller.getInstance().getPrimaryStage().setScene(scene);
        }

        if (select.equals(Constants.INDEPENDENT_SECTIONS)) {

        }

        if (select.equals(Constants.STATEMENTS)) {

        }

        if (select.equals(Constants.ACCOUNTS)) {

        }
    }

}
