package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AddSeparatePane extends BorderPane {

    private Label title = new Label(Constants.TITLE_ADD_SECTION);

    private TextField numberFld = new TextField();
    private TextField areaFld = new TextField();
    private TextArea noteFld = new TextArea();

    private ComboBox<ResidentialCommunity> buildingsBox = new ComboBox<>();
    private ComboBox<String> sectionsBox = new ComboBox<>();

    private Label buildingLbl = new Label(Constants.SELECT_BUILDINGS);
    private Label kindLbl = new Label(Constants.KIND_SECTION);
    private Label numberLbl = new Label(Constants.NUMBER);
    private Label areaLbl = new Label(Constants.FLAT_AREA);
    private Label noteLbl = new Label(Constants.NOTE);

    private Button confirmBtn = new Button(Constants.BUTTON_CONFIRM);
    private Button cancelBtn = new Button(Constants.BUTTON_CANCEL);

    public AddSeparatePane() {
        title.setFont(new Font(Constants.FONT_ARIAL, 20));
        this.setTop(title);

        GridPane gp = new GridPane();
        gp.setStyle(Constants.FX_BORDER_COLOR_BLACK);
        gp.setAlignment(Pos.CENTER);

        gp.setVgap(5);
        gp.setHgap(5);

        gp.add(buildingLbl, 0, 0);
        gp.add(buildingsBox, 1, 0);
        gp.add(kindLbl, 0, 1);
        gp.add(sectionsBox, 1, 1);
        gp.add(numberLbl, 0, 2);
        gp.add(numberFld, 1, 2);
        gp.add(areaLbl, 0, 3);
        gp.add(areaFld, 1, 3);
        gp.add(noteLbl, 0, 4);
        gp.add(noteFld, 1, 4);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(3);
        hBox.setPadding(new Insets(30, 30, 30, 30));

        confirmBtn.setOnAction(Controller.getInstance().getManagerEvent().getConfirmAddSeparateEvent());
        confirmBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getConfirmAddSeparateEvent().confirmAddSeparateEvent();
            }

        });

        cancelBtn.setOnAction(Controller.getInstance().getManagerEvent().getBackListOccupant());
        cancelBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getBackListOccupant().backListOccupant();
            }

        });
        
        buildingsBox.setMaxWidth(USE_PREF_SIZE);
        buildingsBox.setItems(FXCollections.observableArrayList(Controller.getInstance().getTemporaryList().getResidentialCommunitys()));
        
        sectionsBox.setMaxWidth(USE_PREF_SIZE);
        sectionsBox.getItems().addAll(Constants.FLAT, Constants.BUSINESS_SPACE, Constants.GARAGE, Constants.GARAGE_BOX, Constants.GARAGE_SPACE);

        hBox.getChildren().addAll(cancelBtn, confirmBtn);

        this.setPadding(new Insets(60, 60, 60, 60));
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

    public ComboBox<ResidentialCommunity> getBuildingsBox() {
        return buildingsBox;
    }

    public void setBuildingsBox(ComboBox<ResidentialCommunity> buildingsBox) {
        this.buildingsBox = buildingsBox;
    }

    public ComboBox<String> getSectionsBox() {
        return sectionsBox;
    }

    public void setSectionsBox(ComboBox<String> sectionsBox) {
        this.sectionsBox = sectionsBox;
    }
    
    
}
