package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.Occupant;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.occupantgui.TableOccupant;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OccupantDetailsBuildingPane extends VBox {

    private Label occupantLbl = new Label(Constants.OCCUPANT_COLON);
    private ComboBox<Occupant> occupantsBox = new ComboBox<>();
    private Button addOccupant = new Button(Constants.BUTTON_ADD);
    private TableOccupant tableOccupant;

    public OccupantDetailsBuildingPane(List<Occupant> list, HBox hBox) {

        this.setPadding(new Insets(10, 10, 10, 10));

        tableOccupant = new TableOccupant(list);
        Controller.getInstance().setTableOccupant(tableOccupant);

        HBox box = new HBox();
        box.setSpacing(10);
        box.setPadding(new Insets(10, 10, 10, 10));
        box.setAlignment(Pos.CENTER);

        addOccupant.setOnAction(Controller.getInstance().getManagerEvent().getAddOccupantBuildingEvent());
        addOccupant.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getAddOccupantBuildingEvent().addOccupantBuildingEvent();
            }

        });

        Button b = new Button();
        Button b2 = new Button();
        b.setVisible(false);
        b2.setVisible(false);
        box.getChildren().addAll(occupantLbl, occupantsBox, b, b2, addOccupant);

        this.getChildren().addAll(hBox, tableOccupant, box);

    }

    public void reload(List<Occupant> list) {
        tableOccupant.setItems(FXCollections.observableArrayList(list));
    }

}
