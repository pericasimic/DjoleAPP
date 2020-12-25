package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.IndependentSection;
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
import static javafx.scene.layout.Region.USE_PREF_SIZE;

public class EditIndependentPane extends BorderPane {

    private final Label title = new Label();

    private TextField buildingFld = new TextField();
    private TextArea noteFld = new TextArea();
    private TextField nameFld = new TextField();
    private TextField pricePerMonth = new TextField();

    private final Label buildingLbl = new Label(Constants.BUILDING);
    private final Label ownerLbl = new Label(Constants.OWNER);
    private final Label noteLbl = new Label(Constants.NOTE);
    private final Label nameLbl = new Label(Constants.NAME_OF_SECTION);
    private final Label priceLbl = new Label(Constants.PRICE_PER_MONTH);

    private ComboBox<Occupant> owners = new ComboBox<>();

    private final Button exitBtn = new Button(Constants.BUTTON_BACK);
    private final Button editBtn = new Button(Constants.BUTTON_EDIT);

    private HBox hBox = new HBox();

    public EditIndependentPane(IndependentSection section) {

        title.getStyleClass().add(CssId.LOGIN_TITLE);
        title.setText(Constants.TITLE_EDIT_IND_SECTION + section.getName());
        this.setTop(title);

        GridPane gp = new GridPane();
        gp.getStyleClass().add(CssId.GRID_LOGIN);

        buildingFld.setText(Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getName());
        buildingFld.setEditable(false);

        owners.setMaxWidth(USE_PREF_SIZE);
        owners.setItems(FXCollections.observableArrayList(Controller.getInstance().getTemporaryList().getOccupants()));
        if (section.getOwner() != null) {
            owners.getSelectionModel().select(section.getOwner());

        }

        nameFld.setText(section.getName());
        if (section.getNote().isEmpty() || section.getNote() != null) {
            noteFld.setText(section.getNote());
        }
        if (section.getPricePerMonth() != 0) {
            pricePerMonth.setText(String.valueOf(section.getPricePerMonth()));
        }
        

        gp.add(buildingLbl, 0, 1);
        gp.add(buildingFld, 1, 1);
        gp.add(ownerLbl, 0, 2);
        gp.add(owners, 1, 2);
        gp.add(nameLbl, 0, 3);
        gp.add(nameFld, 1, 3);
        gp.add(noteLbl, 0, 4);
        gp.add(noteFld, 1, 4);
        gp.add(priceLbl, 0, 5);
        gp.add(pricePerMonth, 1, 5);

        exitBtn.setOnAction(Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent());
        exitBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent().showSelectBuildTableEvent();
            }

        });
        
        editBtn.setOnAction(Controller.getInstance().getManagerEvent().getConfirmEditIndependentEvent());
        editBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getConfirmEditIndependentEvent().confirmEditIndependentEvent();
            }

        });

        hBox.getStyleClass().add(CssId.HBOX_BOTTOM_MAIN);

        hBox.getChildren().addAll(exitBtn, editBtn);

        this.getStyleClass().add(CssId.BORDER_PANE_DETAILS_SEP_PANE);
        this.setCenter(gp);
        this.setBottom(hBox);
    }

    public TextField getBuildingFld() {
        return buildingFld;
    }

    public void setBuildingFld(TextField buildingFld) {
        this.buildingFld = buildingFld;
    }

    public TextArea getNoteFld() {
        return noteFld;
    }

    public void setNoteFld(TextArea noteFld) {
        this.noteFld = noteFld;
    }

    public TextField getNameFld() {
        return nameFld;
    }

    public void setNameFld(TextField nameFld) {
        this.nameFld = nameFld;
    }

    public TextField getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(TextField pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public ComboBox<Occupant> getOwners() {
        return owners;
    }

    public void setOwners(ComboBox<Occupant> owners) {
        this.owners = owners;
    }

    
    
}
