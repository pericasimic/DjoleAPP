package djoleapp.controller.event.buildingevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.BankDetailsBildingPane;
import djoleapp.gui.maingui.buildinggui.ListSeparateSectionsPane;
import djoleapp.gui.maingui.buildinggui.OccupantDetailsBuildingPane;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class ShowSelectBuildTableEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        showSelectBuildTableEvent();
    }

    public void showSelectBuildTableEvent() {

        TopHBoxBuildingPane thbbp = Controller.getInstance().getTopHBoxBuildingPane();

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

    }

    private void setScene(MainPane mp) {
        Scene scene = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scene);
    }

}
