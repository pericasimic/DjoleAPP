package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.Occupant;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.constant.CssId;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AddSeparatePane extends BorderPane {

    private final Label title = new Label(Constants.TITLE_ADD_SECTION + Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getName());

    private TextField numberFld = new TextField();
    private TextField areaFld = new TextField();
    private TextArea noteFld = new TextArea();

    private ComboBox<String> sectionsBox = new ComboBox<>();
    private ComboBox<Occupant> ownerBox = new ComboBox<>();

    private final Label kindLbl = new Label(Constants.KIND_SECTION);
    private final Label ownerLbl = new Label(Constants.OWNER_IF_EXIST);
    private final Label numberLbl = new Label(Constants.NUMBER);
    private final Label areaLbl = new Label(Constants.FLAT_AREA);
    private final Label noteLbl = new Label(Constants.NOTE);
    private final Label listOccupantLbl = new Label(Constants.OCCUPANT_LIST_TITLE);

    private final Button confirmBtn = new Button(Constants.BUTTON_CONFIRM);
    private final Button cancelBtn = new Button(Constants.BUTTON_CANCEL);

    public AddSeparatePane() {
        title.getStyleClass().add(CssId.LABEL_TITTLE);
        this.setTop(title);

        GridPane gp = new GridPane();
        gp.getStyleClass().add(CssId.GRID_LOGIN);

        gp.add(kindLbl, 0, 0);
        gp.add(sectionsBox, 1, 0);
        gp.add(ownerLbl, 0, 1);
        gp.add(ownerBox, 1, 1);
        gp.add(numberLbl, 0, 2);
        gp.add(numberFld, 1, 2);
        gp.add(areaLbl, 0, 3);
        gp.add(areaFld, 1, 3);
        gp.add(noteLbl, 0, 4);
        gp.add(noteFld, 1, 4);

        HBox hBox = new HBox();
        hBox.getStyleClass().add(CssId.HBOX_BOTTOM_MAIN);

        confirmBtn.setOnAction(Controller.getInstance().getManagerEvent().getConfirmAddSeparateEvent());
        confirmBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getConfirmAddSeparateEvent().confirmAddSeparateEvent();
            }

        });

        cancelBtn.setOnAction(Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent());
        cancelBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent().showSelectBuildTableEvent();
            }

        });

        sectionsBox.setMaxWidth(USE_PREF_SIZE);
        sectionsBox.getItems().addAll(Constants.FLAT, Constants.BUSINESS_SPACE, Constants.GARAGE, Constants.GARAGE_BOX, Constants.GARAGE_SPACE);

        ownerBox.setMaxWidth(USE_PREF_SIZE);
        ownerBox.setItems(FXCollections.observableArrayList(Controller.getInstance().getTemporaryList().getOccupants()));

        hBox.getChildren().addAll(cancelBtn, confirmBtn);

        this.getStyleClass().add(CssId.BORDER_PANE_DETAILS_SEP_PANE);
        this.setCenter(gp);
        this.setBottom(hBox);

    }

    public TextField getNumberFld() {
        return numberFld;
    }

    public void setNumberFld(TextField numberFld) {
        this.numberFld = numberFld;
    }

    public TextField getAreaFld() {
        return areaFld;
    }

    public void setAreaFld(TextField areaFld) {
        this.areaFld = areaFld;
    }

    public void setNoteFld(TextArea noteFld) {
        this.noteFld = noteFld;
    }

    public TextArea getNoteFld() {
        return noteFld;
    }

    public ComboBox<String> getSectionsBox() {
        return sectionsBox;
    }

    public void setSectionsBox(ComboBox<String> sectionsBox) {
        this.sectionsBox = sectionsBox;
    }

    public ComboBox<Occupant> getOwnerBox() {
        return ownerBox;
    }

    public void setOwnerBox(ComboBox<Occupant> ownerBox) {
        this.ownerBox = ownerBox;
    }

}
