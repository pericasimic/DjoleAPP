package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.BusinessSpace;
import djoleapp.business.model.Flat;
import djoleapp.business.model.Garage;
import djoleapp.business.model.IndependentSection;
import djoleapp.business.model.ParkingBox;
import djoleapp.business.model.ParkingSpace;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class DetailsIndependentPane extends BorderPane {

    private Label title = new Label();

    private TextField buildingFld = new TextField();
    private TextField ownerFld = new TextField();
    private TextArea noteFld = new TextArea();

    private Label buildingLbl = new Label(Constants.SELECT_BUILDINGS);
    private Label ownerLbl = new Label(Constants.OWNER);
    private Label noteLbl = new Label(Constants.NOTE);

    private Button editBtn = new Button(Constants.BUTTON_EDIT);
    private Button confirmBtn = new Button(Constants.BUTTON_CONFIRM);
    private Button cancelBtn = new Button(Constants.BUTTON_CANCEL);

    private IndependentSection independentSection;

    private HBox hBox = new HBox();

    public DetailsIndependentPane(IndependentSection section) {

        setIndependentSection(section);

        title.setFont(new Font(Constants.FONT_ARIAL, 20));
        this.setTop(title);

        GridPane gp = new GridPane();
        gp.setStyle(Constants.FX_BORDER_COLOR_BLACK);
        gp.setAlignment(Pos.CENTER);

        gp.setVgap(5);
        gp.setHgap(5);

        gp.add(buildingLbl, 0, 1);
        gp.add(buildingFld, 1, 1);
//        buildingFld.setText(section.getResidentialCommunity().getName());
//        buildingFld.setEditable(false);
//        gp.add(ownerLbl, 0, 2);
//        gp.add(ownerFld, 1, 2);
//        ownerFld.setEditable(false);
//
//        if (section.getOwner() != null) {
//            ownerFld.setText(section.getOwner().getFirstNameOccupant() + section.getOwner().getLastNameOccupant());
//        }
//
//        gp.add(numberLbl, 0, 3);
//        gp.add(numberFld, 1, 3);
//        numberFld.setEditable(false);
//        numberFld.setText(section.getNumber());
//        gp.add(areaLbl, 0, 4);
//        gp.add(areaFld, 1, 4);
//        areaFld.setEditable(false);
//        areaFld.setText(String.valueOf(section.getSurfaceArea()));
        gp.add(noteLbl, 0, 5);
        gp.add(noteFld, 1, 5);
        noteFld.setEditable(false);
        noteFld.setText(section.getNote());

        cancelBtn.setOnAction(Controller.getInstance().getManagerEvent().getBackListSeparateSections());
        cancelBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getBackListSeparateSections();
            }

        });

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(3);
        hBox.setPadding(new Insets(30, 30, 30, 30));

        editBtn.setOnAction(Controller.getInstance().getManagerEvent().getEditSeparationEvent());
        editBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getEditSeparationEvent().editSeparationEvent();
            }

        });
        hBox.getChildren().addAll(cancelBtn, editBtn);

        this.setPadding(new Insets(60, 60, 60, 60));
        this.setCenter(gp);
        this.setBottom(hBox);
    }

    public IndependentSection getIndependentSection() {
        return independentSection;
    }

    public void setIndependentSection(IndependentSection independentSection) {
        this.independentSection = independentSection;
    }
    
}
