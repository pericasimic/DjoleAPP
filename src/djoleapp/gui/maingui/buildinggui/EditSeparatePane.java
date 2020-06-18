package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.Factory;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import java.util.List;
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
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;

public class EditSeparatePane extends BorderPane {

    private Label title = new Label(Constants.SECTION_EDIT_TITLE); 

    private TextField sectionFld = new TextField();
    private TextField numberFld = new TextField();
    private TextField areaFld = new TextField();
    private TextArea noteFld = new TextArea();

    private ComboBox<ResidentialCommunity> buildingsBox = new ComboBox<>();
    private ComboBox<Occupant> ownerBox = new ComboBox<>();

    private Label buildingLbl = new Label(Constants.SELECT_BUILDINGS);
    private Label kindLbl = new Label(Constants.KIND_SECTION);
    private Label ownerLbl = new Label(Constants.OWNER);
    private Label numberLbl = new Label(Constants.NUMBER);
    private Label areaLbl = new Label(Constants.FLAT_AREA);
    private Label noteLbl = new Label(Constants.NOTE);
    private Label listOccupantLbl = new Label(Constants.OCCUPANT_LIST_TITLE);

    private Button confirmEditBtn = new Button(Constants.BUTTON_CONFIRM);
    private Button cancelBtn = new Button(Constants.BUTTON_CANCEL);
    private Button addOccupant = new Button(Constants.BUTTON_ADD_OCCUPANT);

    public EditSeparatePane() {
        
        SeparateSection section = Controller.getInstance().getTemporarySeparateSection();
        reloadOwnersBox(Controller.getInstance().getTemporaryList().getOccupants());
        
        title.setFont(new Font(Constants.FONT_ARIAL, 20));
        this.setTop(title);

        GridPane gp = new GridPane();
        gp.setStyle(Constants.FX_BORDER_COLOR_BLACK);
        gp.setAlignment(Pos.CENTER);

        gp.setVgap(5);
        gp.setHgap(5);

        gp.add(kindLbl, 0, 0);
        gp.add(sectionFld, 1, 0);
        sectionFld.setText(Factory.getFacade().kindOfSection(section));
        sectionFld.setEditable(false);
        gp.add(buildingLbl, 0, 1);
        gp.add(buildingsBox, 1, 1);
        buildingsBox.getSelectionModel().select(section.getResidentialCommunity());
        gp.add(ownerLbl, 0, 2);
        gp.add(ownerBox, 1, 2);
        if(section.getOwner() != null){
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
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(3);
        hBox.setPadding(new Insets(30, 30, 30, 30));

        confirmEditBtn.setOnAction(Controller.getInstance().getManagerEvent().getConfirmEditSeparateEvent());
        confirmEditBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getConfirmEditSeparateEvent();
            }

        });

        cancelBtn.setOnAction(Controller.getInstance().getManagerEvent().getBackListSeparateSections());
        cancelBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getBackListSeparateSections();
            }

        });

        buildingsBox.setMaxWidth(USE_PREF_SIZE);
        buildingsBox.setItems(FXCollections.observableArrayList(Controller.getInstance().getTemporaryList().getResidentialCommunitys()));

        ownerBox.setMaxWidth(USE_PREF_SIZE);

        hBox.getChildren().addAll(cancelBtn, confirmEditBtn);

        this.setPadding(new Insets(60, 60, 60, 60));
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

    public ComboBox<ResidentialCommunity> getBuildingsBox() {
        return buildingsBox;
    }

    public void setBuildingsBox(ComboBox<ResidentialCommunity> buildingsBox) {
        this.buildingsBox = buildingsBox;
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
