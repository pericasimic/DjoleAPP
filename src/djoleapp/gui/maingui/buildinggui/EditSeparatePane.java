package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.Factory;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.constant.CssId;
import java.util.List;
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
import static javafx.scene.layout.Region.USE_PREF_SIZE;

public class EditSeparatePane extends BorderPane {

    private final Label title = new Label(Constants.SECTION_EDIT_TITLE);

    private TextField sectionFld = new TextField();
    private TextField numberFld = new TextField();
    private TextField areaFld = new TextField();
    private TextArea noteFld = new TextArea();
    private TextField buildingFld = new TextField();

    private ComboBox<Occupant> ownerBox = new ComboBox<>();

    private final Label buildingLbl = new Label(Constants.SELECT_BUILDINGS);
    private final Label kindLbl = new Label(Constants.KIND_SECTION);
    private final Label ownerLbl = new Label(Constants.OWNER);
    private final Label numberLbl = new Label(Constants.NUMBER);
    private final Label areaLbl = new Label(Constants.FLAT_AREA);
    private final Label noteLbl = new Label(Constants.NOTE);
    private final Label listOccupantLbl = new Label(Constants.OCCUPANT_LIST_TITLE);

    private final Button confirmEditBtn = new Button(Constants.BUTTON_CONFIRM);
    private final Button cancelBtn = new Button(Constants.BUTTON_CANCEL);
    private final Button addOccupant = new Button(Constants.BUTTON_ADD_OCCUPANT);

    public EditSeparatePane() {

        SeparateSection section = Controller.getInstance().getTemporarySeparateSection();
        reloadOwnersBox(Controller.getInstance().getTemporaryList().getOccupants());

        title.getStyleClass().add(CssId.LABEL_TITTLE);
        this.setTop(title);

        GridPane gp = new GridPane();
        gp.getStyleClass().add(CssId.GRID_LOGIN);

        gp.add(kindLbl, 0, 0);
        gp.add(sectionFld, 1, 0);
        sectionFld.setText(Factory.getFacade().kindOfSection(section));
        sectionFld.setEditable(false);
        gp.add(buildingLbl, 0, 1);
        gp.add(buildingFld, 1, 1);
        buildingFld.setEditable(false);
        buildingFld.setText(section.getResidentialCommunity().toString());
        gp.add(ownerLbl, 0, 2);
        gp.add(ownerBox, 1, 2);
        if (section.getOwner() != null) {
            ownerBox.getSelectionModel().select(section.getOwner());
        }
        gp.add(numberLbl, 0, 3);
        gp.add(numberFld, 1, 3);
        numberFld.setText(section.getNumber());
        gp.add(areaLbl, 0, 4);
        gp.add(areaFld, 1, 4);
        areaFld.setText(Double.toString(section.getSurfaceArea()));
        gp.add(noteLbl, 0, 5);
        gp.add(noteFld, 1, 5);
        noteFld.setText(section.getNote());

        HBox hBox = new HBox();
        hBox.getStyleClass().add(CssId.HBOX_BOTTOM_MAIN);

        confirmEditBtn.setOnAction(Controller.getInstance().getManagerEvent().getConfirmEditSeparateEvent());
        confirmEditBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getConfirmEditSeparateEvent();
            }

        });

        cancelBtn.setOnAction(Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent());
        cancelBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent().showSelectBuildTableEvent();
            }

        });


        ownerBox.setMaxWidth(USE_PREF_SIZE);

        hBox.getChildren().addAll(cancelBtn, confirmEditBtn);

        this.getStyleClass().add(CssId.BORDER_PANE_DETAILS_SEP_PANE);
        this.setCenter(gp);
        this.setBottom(hBox);
    }

    public void reloadOwnersBox(List<Occupant> list) {
        ownerBox.setItems(FXCollections.observableArrayList(list));
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

    public TextArea getNoteFld() {
        return noteFld;
    }

    public void setNoteFld(TextArea noteFld) {
        this.noteFld = noteFld;
    }

    public void setBuildingFld(TextField buildingFld) {
        this.buildingFld = buildingFld;
    }

    public TextField getBuildingFld() {
        return buildingFld;
    }

    public ComboBox<Occupant> getOwnerBox() {
        return ownerBox;
    }

    public void setOwnerBox(ComboBox<Occupant> ownerBox) {
        this.ownerBox = ownerBox;
    }

    public TextField getSectionFld() {
        return sectionFld;
    }

    public void setSectionFld(TextField sectionFld) {
        this.sectionFld = sectionFld;
    }

}
