package djoleapp.controller.event.buildingevent;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.AddSeparatePane;
import djoleapp.gui.maingui.buildinggui.ListSeparateSectionsPane;
import djoleapp.gui.maingui.buildinggui.TopHBoxBuildingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class AddSectionEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        addSectionEvent();
    }

    public void addSectionEvent() {
        AddSeparatePane asp = new AddSeparatePane();
        Controller.getInstance().setAddSeparatePane(asp);
        Scene scena = new Scene(asp, Constants.SCENE_WIDTH_TEMP, Constants.SCENE_HEIGHT_TEMP);
        Stage stage = new Stage();
        stage.setScene(scena);
        stage.setTitle(Constants.SEPARATE_SECTIONS);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                setScene();
            }
        });
        stage.show();
        Controller.getInstance().setTemporaryStage(stage);
        Controller.getInstance().getPrimaryStage().hide();
    }

    public void setScene() {
        Controller.getInstance().getPrimaryStage().show();
        ListSeparateSectionsPane lssp = Controller.getInstance().getListSeparateSectionsPane();
        MainPane mp = new MainPane(lssp);
        Scene scene = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scene);
    }

}
