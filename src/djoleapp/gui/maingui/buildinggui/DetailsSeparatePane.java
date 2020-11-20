package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.Factory;
import djoleapp.business.model.BusinessSpace;
import djoleapp.business.model.Flat;
import djoleapp.business.model.Garage;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ParkingBox;
import djoleapp.business.model.ParkingSpace;
import djoleapp.business.model.SeparateSection;
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

public class DetailsSeparatePane extends BorderPane {
    
    private final Label title = new Label();
    
    private TextField buildingFld = new TextField();
    private TextField ownerFld = new TextField();
    private TextField numberFld = new TextField();
    private TextField areaFld = new TextField();
    private TextArea noteFld = new TextArea();
    private TextField investmentMaintenanceFld = new TextField();
    
    private final Label buildingLbl = new Label(Constants.SELECT_BUILDINGS);
    private final Label ownerLbl = new Label(Constants.OWNER);
    private final Label numberLbl = new Label(Constants.NUMBER);
    private final Label areaLbl = new Label(Constants.FLAT_AREA);
    private final Label noteLbl = new Label(Constants.NOTE);
    private final Label occupants = new Label(Constants.OCCUPANTS);
    private final Label investmentMaintenanceLbl = new Label();
    
    private ComboBox<Occupant> occupantsBox = new ComboBox<>();
    
    private final Button editBtn = new Button(Constants.BUTTON_EDIT);
    private final Button confirmBtn = new Button(Constants.BUTTON_CONFIRM);
    private final Button cancelBtn = new Button(Constants.BUTTON_CANCEL);
    
    private SeparateSection separateSection;
    
    private HBox hBox = new HBox();
    
    public DetailsSeparatePane(SeparateSection section) {
        
        setSeparateSection(section);
        
        title.getStyleClass().add(CssId.LABEL_TITTLE);
        
        this.setTop(title);
        
        GridPane gp = new GridPane();
        gp.getStyleClass().add(CssId.GRID_LOGIN);

        gp.add(buildingLbl, 0, 1);
        gp.add(buildingFld, 1, 1);
        buildingFld.setText(section.getResidentialCommunity().getName());
        buildingFld.setEditable(false);
        gp.add(ownerLbl, 0, 2);
        gp.add(ownerFld, 1, 2);
        ownerFld.setEditable(false);
        
        if (section.getOwner() != null) {
            ownerFld.setText(section.getOwner().getFirstNameOccupant() + section.getOwner().getLastNameOccupant());
        }
        
        gp.add(numberLbl, 0, 3);
        gp.add(numberFld, 1, 3);
        numberFld.setEditable(false);
        numberFld.setText(section.getNumber());
        gp.add(areaLbl, 0, 4);
        gp.add(areaFld, 1, 4);
        areaFld.setEditable(false);
        areaFld.setText(String.valueOf(section.getSurfaceArea()));
        gp.add(noteLbl, 0, 5);
        gp.add(noteFld, 1, 5);
        noteFld.setEditable(false);
        noteFld.setText(section.getNote());
        gp.add(investmentMaintenanceLbl, 0, 6);
        gp.add(investmentMaintenanceFld, 1, 6);
        investmentMaintenanceFld.setEditable(false);
        
        if (section instanceof Flat) {
            title.setText(Constants.SECTION_DETAILS_TITLE + " " + Constants.FLAT);
            investmentMaintenanceLbl.setText(Constants.INVESTEMENT_MAINTENANCE + " " + Controller.getInstance().getPricePerMonthFlat() + " din/m2");
            investmentMaintenanceFld.setText(String.valueOf(Factory.getFacade().supportSum(Controller.getInstance().getPricePerMonthFlat(), section.getSurfaceArea())));
            gp.add(occupants, 0, 7);
            gp.add(occupantsBox, 1, 7);
            occupantsBox.setItems(FXCollections.observableArrayList(Factory.getFacade().getListOccupantsPerFlat((Flat) section)));
        }
        if (section instanceof Garage) {
            title.setText(Constants.SECTION_DETAILS_TITLE + " " + Constants.GARAGE);
            investmentMaintenanceLbl.setText(Constants.INVESTEMENT_MAINTENANCE + " " + Controller.getInstance().getPricePerMonthGarage() + " din/m2");
            investmentMaintenanceFld.setText(String.valueOf(Factory.getFacade().supportSum(Controller.getInstance().getPricePerMonthGarage(), section.getSurfaceArea())));
        }
        if (section instanceof BusinessSpace) {
            title.setText(Constants.SECTION_DETAILS_TITLE + " " + Constants.BUSINESS_SPACE);
            investmentMaintenanceLbl.setText(Constants.INVESTEMENT_MAINTENANCE + " " + Controller.getInstance().getPricePerMonthBusiness() + " din/m2");
            investmentMaintenanceFld.setText(String.valueOf(Factory.getFacade().supportSum(Controller.getInstance().getPricePerMonthBusiness(), section.getSurfaceArea())));
        }
        if (section instanceof ParkingBox) {
            title.setText(Constants.SECTION_DETAILS_TITLE + " " + Constants.GARAGE_BOX);
            investmentMaintenanceLbl.setText(Constants.INVESTEMENT_MAINTENANCE + " " + Controller.getInstance().getPricePerMonthBox() + " din/m2");
            investmentMaintenanceFld.setText(String.valueOf(Factory.getFacade().supportSum(Controller.getInstance().getPricePerMonthBox(), section.getSurfaceArea())));
        }
        if (section instanceof ParkingSpace) {
            title.setText(Constants.SECTION_DETAILS_TITLE + " " + Constants.GARAGE_SPACE);
            investmentMaintenanceLbl.setText(Constants.INVESTEMENT_MAINTENANCE + " " + Controller.getInstance().getPricePerMonthSpace() + " din/m2");
            investmentMaintenanceFld.setText(String.valueOf(Factory.getFacade().supportSum(Controller.getInstance().getPricePerMonthSpace(), section.getSurfaceArea())));
        }
        
        cancelBtn.setOnAction(Controller.getInstance().getManagerEvent().getBackListSeparateSections());
        cancelBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getBackListSeparateSections();
            }
            
        });
        
        hBox.getStyleClass().add(CssId.HBOX_BOTTOM_MAIN);
        
        editBtn.setOnAction(Controller.getInstance().getManagerEvent().getEditSeparationEvent());
        editBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getEditSeparationEvent().editSeparationEvent();
            }
            
        });
        hBox.getChildren().addAll(cancelBtn, editBtn);
        
        this.getStyleClass().add(CssId.BORDER_PANE_DETAILS_SEP_PANE);
        this.setCenter(gp);
        this.setBottom(hBox);
    }
    
    public SeparateSection getSeparateSection() {
        return separateSection;
    }
    
    public void setSeparateSection(SeparateSection separateSection) {
        this.separateSection = separateSection;
    }
    
}
