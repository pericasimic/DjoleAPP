package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.Factory;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.event.ComboBoxAutoComplete;
import djoleapp.gui.maingui.occupantgui.TableOccupant;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OccupantDetailsBuildingPane extends VBox {

    private Label occupantLbl = new Label(Constants.OCCUPANT_COLON);
    private Label separateLbl = new Label(Constants.INDEPENDENT_SECTIONS);
    private ComboBox<Occupant> occupantsBox = new ComboBox<>();
    private ComboBox<SeparateSection> sections = new ComboBox<>();
    private Button addOccupant = new Button(Constants.BUTTON_ADD);
    private Button removeBtn = new Button(Constants.BUTTON_REMOVE);
    private TableOccupant tableOccupant;

    public OccupantDetailsBuildingPane(List<Occupant> list, HBox hBox) {

        this.setPadding(new Insets(10, 10, 10, 10));

        reloadBox();

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

        removeBtn.setOnAction(Controller.getInstance().getManagerEvent().getRemoveBuildingOccupantEvent());
        removeBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getRemoveBuildingOccupantEvent();
            }

        });

        sections.setItems(FXCollections.observableArrayList(Factory.getFacade().getFlats(Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue())));
        new ComboBoxAutoComplete<SeparateSection>(sections);

        Button b = new Button();
        Button b2 = new Button();
        b.setVisible(false);
        b2.setVisible(false);
        box.getChildren().addAll(separateLbl, sections, occupantLbl, occupantsBox, b, b2, removeBtn);

        HBox hBox2 = new HBox();
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().add(addOccupant);

        this.getChildren().addAll(hBox, tableOccupant, box, hBox2);

    }

    public void reload(List<Occupant> list) {
        tableOccupant.setItems(FXCollections.observableArrayList(list));

    }

    public void reloadBox() {
        occupantsBox.setItems(FXCollections.observableArrayList(Factory.getFacade().getListfreeOccupants()));
    }


    public ComboBox<Occupant> getOccupantsBox() {
        return occupantsBox;
    }

    public ComboBox<SeparateSection> getSections() {
        return sections;
    }

    public TableOccupant getTableOccupant() {
        return tableOccupant;
    }

}
