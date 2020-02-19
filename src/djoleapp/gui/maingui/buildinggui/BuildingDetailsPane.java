package djoleapp.gui.maingui.buildinggui;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BuildingDetailsPane extends VBox {

    public BuildingDetailsPane(HBox hBox) {
        this.getChildren().addAll(hBox);
        this.setPadding(new Insets(10, 10, 10, 10));
    }
}
