package djoleapp.gui.maingui.occupantgui;

import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ListOccupantsPane extends VBox {

    private Label titleLbl = new Label(Constants.OCCUPANT_LIST_TITLE);
    private TableView<Occupant> tableOccupants = new TableView<>();
    private List<Occupant> listOccupants = null;

    private TextField searchOccupantFld = new TextField();

    private Button addOccupantBtn = new Button(Constants.BUTTON_ADD);
    private Button removeOccupantBtn = new Button(Constants.BUTTON_REMOVE);
    private Button searchOccupantBtn = new Button(Constants.BUTTON_SEARCH);

//    public ListOccupantsPane() {
//        titleLbl.setFont(new Font(Constants.FONT_ARIAL, 20));
//        setSpacing(5);
//        setPadding(new Insets(10, 10, 10, 10));
//
//        TableColumn idBuildingCol = new TableColumn(Constants.ID);
//        idBuildingCol.setMinWidth(150);
//        idBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, Object>("id"));
//
//        TableColumn nameBuildingCol = new TableColumn(Constants.NAME_OF_BUILDING);
//        nameBuildingCol.setMinWidth(150);
//        nameBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("name"));
//
//        TableColumn idNumBuildingCol = new TableColumn(Constants.ID_NUM);
//        idNumBuildingCol.setMinWidth(150);
//        idNumBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("identificationNumber"));
//
//        TableColumn taxNumBuildingCol = new TableColumn(Constants.TAX_NUM_BUILDING);
//        taxNumBuildingCol.setMinWidth(150);
//        taxNumBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("taxIdentificationNumber"));
//
//        TableColumn mailNumBuildingCol = new TableColumn(Constants.MAIL);
//        mailNumBuildingCol.setMinWidth(150);
//        mailNumBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("mail"));
//
//        reload();
//        tableBuildings.getColumns().addAll(idBuildingCol, nameBuildingCol, idNumBuildingCol, taxNumBuildingCol, mailNumBuildingCol);
//        getChildren().addAll(titleLbl, getSearch(), tableBuildings, getForm());
//
//    }
//    
//    private HBox getSearch(){
//        
//        HBox hSearch = new HBox();
//        hSearch.setSpacing(3);
//        hSearch.setPadding(new Insets(10, 10, 10, 10));
//        hSearch.setAlignment(Pos.CENTER);
//
//        searchBuildingFld.setMaxWidth(USE_PREF_SIZE);
//
////        searchBuildingBtn.setOnAction(Controller.getInstance().getManagerEvent().getSearchUserEvent());
////        searchBuildingBtn.setOnKeyPressed(e -> {
////            if (e.getCode() == KeyCode.ENTER) {
////                Controller.getInstance().getManagerEvent().getSearchUserEvent().searchUserEvent();
////            }
////        });
//
//        hSearch.getChildren().addAll(searchBuildingFld, searchBuildingBtn);
//        return hSearch;
//        
//    }
//    
//    private HBox getForm() {
//
//        HBox hbox = new HBox();
//        hbox.setSpacing(3);
//        hbox.setPadding(new Insets(10, 10, 10, 10));
//        hbox.setAlignment(Pos.CENTER);
//
//        nameBuildingFld.setMaxWidth(USE_PREF_SIZE);
//        nameBuildingFld.setPromptText(Constants.NAME_OF_BUILDING);
//
//        idNumBuildingFld.setMaxWidth(USE_PREF_SIZE);
//        idNumBuildingFld.setPromptText(Constants.ID_NUM);
//
//        tidNumBuildingFld.setMaxWidth(USE_PREF_SIZE);
//        tidNumBuildingFld.setPromptText(Constants.TAX_NUM_BUILDING);
//
//        mailBuildingFld.setMaxWidth(USE_PREF_SIZE);
//        mailBuildingFld.setPromptText(Constants.MAIL);
//
//        addBuildingBtn.setOnAction(Controller.getInstance().getManagerEvent().getAddBuildingEvent());
//        addBuildingBtn.setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.ENTER) {
//                Controller.getInstance().getManagerEvent().getAddBuildingEvent().addBuildingEvent();
//            }
//
//        });
//
////        removeBtn.setOnAction(Controller.getInstance().getManagerEvent().getRemoveUserEvent());
////        removeBtn.setOnKeyPressed(e -> {
////            if (e.getCode() == KeyCode.ENTER) {
////                Controller.getInstance().getManagerEvent().getRemoveUserEvent().removeUserEvent();
////            }
////
////        });
//
//        hbox.getChildren().addAll(nameBuildingFld, idNumBuildingFld, tidNumBuildingFld, mailBuildingFld, removeBuildingBtn, addBuildingBtn);
//        return hbox;
//    }
//    
//    public void clearAllFields() {
//        nameBuildingFld.setText(Constants.EMPTY_STRING);
//        idNumBuildingFld.setText(Constants.EMPTY_STRING);
//        tidNumBuildingFld.setText(Constants.EMPTY_STRING);
//        mailBuildingFld.setText(Constants.EMPTY_STRING);
//    }
//
//    public void reload(){
//        listBuildings = Controller.getInstance().getTemporaryList().getResidentialCommunitys();
//        tableBuildings.setItems(FXCollections.observableArrayList(listBuildings));
//    }
//    
}
