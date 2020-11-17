package djoleapp.controller.event.buildingevent;

import djoleapp.DjoleAPP;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.BankDetailsBildingPane;
import djoleapp.gui.maingui.buildinggui.ListCommonSectionPane;
import djoleapp.gui.maingui.buildinggui.ListIndependentSectionsPane;
import djoleapp.gui.maingui.buildinggui.ListSeparateSectionsPane;
import djoleapp.gui.maingui.buildinggui.OccupantDetailsBuildingPane;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

/*
TopHBoxBuildingPane
 */
public class ShowSelectBuildTableEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        showSelectBuildTableEvent();
    }

    public void showSelectBuildTableEvent() {

        TopHBoxBuildingPane thbbp = Controller.getInstance().getTopHBoxBuildingPane();

        if (thbbp.getBuildingsBox().getValue() != null && thbbp.getSelectItemBox().getValue() != null) {

            if (thbbp.getSelectItemBox().getValue().equals(Constants.BANK_ACCOUNT)) {
                BankDetailsBildingPane bdbp = new BankDetailsBildingPane(thbbp.getBuildingsBox().getValue().getBankAccounts(), thbbp);
                thbbp.getBuildingsBox().setValue(thbbp.getBuildingsBox().getValue());
                Controller.getInstance().setBankDetailsBildingPane(bdbp);
                MainPane mp = new MainPane(bdbp);
                setScene(mp);

            }

            if (thbbp.getSelectItemBox().getValue().equals(Constants.OCCUPANTS)) {
                OccupantDetailsBuildingPane odbp = new OccupantDetailsBuildingPane(thbbp.getBuildingsBox().getValue().getListOccupants(), thbbp);
                thbbp.getBuildingsBox().setValue(thbbp.getBuildingsBox().getValue());
                Controller.getInstance().setOccupantDetailsBuildingPane(odbp);
                MainPane mp = new MainPane(odbp);
                setScene(mp);

            }

            if (thbbp.getSelectItemBox().getValue().equals(Constants.SEPARATE_SECTIONS)) {
                ListSeparateSectionsPane lssp = new ListSeparateSectionsPane(thbbp.getBuildingsBox().getValue().getListSeparationSection(), thbbp);
                thbbp.getBuildingsBox().setValue(thbbp.getBuildingsBox().getValue());
                Controller.getInstance().setListSeparateSectionsPane(lssp);
                MainPane mp = new MainPane(lssp);
                setScene(mp);
            }

            if (thbbp.getSelectItemBox().getValue().equals(Constants.INDEPENDENT_SECTIONS)) {
                ListIndependentSectionsPane lisp = new ListIndependentSectionsPane(thbbp.getBuildingsBox().getValue().getListIndependentSections(), thbbp);
                thbbp.getBuildingsBox().setValue(thbbp.getBuildingsBox().getValue());
                Controller.getInstance().setListIndependentSectionsPane(lisp);
                MainPane mp = new MainPane(lisp);
                setScene(mp);
            }

            if (thbbp.getSelectItemBox().getValue().equals(Constants.COMMON_SECTIONS)) {
                ListCommonSectionPane lcsp = new ListCommonSectionPane(thbbp.getBuildingsBox().getValue().getListCommonSections(), thbbp);
                thbbp.getBuildingsBox().setValue(thbbp.getBuildingsBox().getValue());
                Controller.getInstance().setListCommonSectionPane(lcsp);
                MainPane mp = new MainPane(lcsp);
                setScene(mp);
            }
        } else {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_NOT_SELECT);
            return;
        }

    }

    private void setScene(MainPane mp) {
        Scene scene = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        scene.getStylesheets().add(DjoleAPP.class.getResource(Constants.STYLE_PATH).toExternalForm());
        Controller.getInstance().getPrimaryStage().setScene(scene);
    }

}
