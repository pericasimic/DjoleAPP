package djoleapp.controller.event.buildingevent;

import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.DetailsSeparatePane;
import djoleapp.gui.maingui.buildinggui.ListSeparateSectionsPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DetailsSeparateEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {

    }

    public void detailsSeparateEvent(SeparateSection section) {
        Controller.getInstance().setTemporarySeparateSection(section);
        DetailsSeparatePane dsp = new DetailsSeparatePane(section);
        Controller.getInstance().setDetailsSeparatePane(dsp);
        Scene scena = new Scene(dsp, Constants.SCENE_WIDTH_TEMP, Constants.SCENE_HEIGHT_TEMP);
        Stage stage = new Stage();
        Controller.getInstance().setTemporaryStage(stage);
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
