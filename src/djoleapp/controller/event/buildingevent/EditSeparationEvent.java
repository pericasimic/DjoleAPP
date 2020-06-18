package djoleapp.controller.event.buildingevent;

import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.buildinggui.DetailsSeparatePane;
import djoleapp.gui.maingui.buildinggui.EditSeparatePane;
import djoleapp.gui.maingui.buildinggui.ListSeparateSectionsPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class EditSeparationEvent implements EventHandler<ActionEvent> {

    Stage stage = new Stage();

    @Override
    public void handle(ActionEvent event) {
        editSeparationEvent();
    }

    public void editSeparationEvent() {
        EditSeparatePane esp = new EditSeparatePane();
        Controller.getInstance().setEditSeparatePane(esp);
        Scene scena = new Scene(esp, Constants.SCENE_WIDTH_TEMP, Constants.SCENE_HEIGHT_TEMP);
        stage.setScene(scena);
        stage.setTitle(Constants.SECTION_EDIT_TITLE);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                setScene();
            }
        });
        stage.show();
        Controller.getInstance().getTemporaryStage().hide();

    }

    public void setScene() {
        Controller.getInstance().getPrimaryStage().show();
        stage.close();
        ListSeparateSectionsPane lssp = Controller.getInstance().getListSeparateSectionsPane();
        MainPane mp = new MainPane(lssp);
        Scene scene = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scene);
    }

    public Stage getStage() {
        return stage;
    }
    
    
}
