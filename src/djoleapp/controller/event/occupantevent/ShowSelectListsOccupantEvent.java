package djoleapp.controller.event.occupantevent;

import djoleapp.business.Factory;
import djoleapp.business.model.Occupant;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.finance.AccountCalculationPane;
import djoleapp.gui.maingui.buildinggui.ListIndependentSectionsPane;
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
            setScene(mp);
        }

        if (select.equals(Constants.INDEPENDENT_SECTIONS)) {
            ListIndependentSectionsPane lisp = new ListIndependentSectionsPane(Factory.getFacade().getIndSectionPerOccupant(o));
            Controller.getInstance().setListIndependentSectionsPane(lisp);
            MainPane mp = new MainPane(lisp);
            setScene(mp);
        }

        if (select.equals(Constants.STATEMENTS)) {

        }

        if (select.equals(Constants.ACCOUNTS)) {
            AccountCalculationPane acp = new AccountCalculationPane(Controller.getInstance().getTemporaryOccupant());
            Controller.getInstance().setAccountCalculationPane(acp);
            MainPane mp = new MainPane(acp);
            setScene(mp);
        }
    }

    private void setScene(MainPane mp) {
        Scene scene = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scene);
    }

}
