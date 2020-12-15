package djoleapp.controller.event;

import djoleapp.controller.constant.Constants;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

/**
 *
 * @author perica.simic
 */
public class CloseAppEvent implements EventHandler<WindowEvent> {

    @Override
    public void handle(WindowEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING, Constants.CLOSE_APP_DIALOG_TEXT, ButtonType.YES, ButtonType.NO);
        alert.setHeaderText(null);
        ButtonType result = alert.showAndWait().orElse(ButtonType.NO);
        if (ButtonType.NO.equals(result)) {
            event.consume();
        }
    }

}
