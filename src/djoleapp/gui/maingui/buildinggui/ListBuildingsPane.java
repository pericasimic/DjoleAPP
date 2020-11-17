package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.CssId;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import djoleapp.controller.constant.Constants;
import java.util.List;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class ListBuildingsPane extends VBox {

    private final Label titleLbl = new Label(Constants.BUILDINGS_LIST_TITLE);
    private TableView<ResidentialCommunity> tableBuildings = new TableView<>();
    private List<ResidentialCommunity> listBuildings = null;

    private TextField nameBuildingFld = new TextField();
    private TextField numberBuildingFld = new TextField();
    private TextField idNumBuildingFld = new TextField();
    private TextField tidNumBuildingFld = new TextField();
    private TextField mailBuildingFld = new TextField();
    private TextField searchBuildingFld = new TextField();
    private TextField cityBuildingFld = new TextField();

    private Button addBuildingBtn = new Button(Constants.BUTTON_ADD);
    private Button removeBuildingBtn = new Button(Constants.BUTTON_REMOVE);
    private Button searchBuildingBtn = new Button(Constants.BUTTON_SEARCH);

    private boolean isSearch = false;

    public ListBuildingsPane() {
        titleLbl.getStyleClass().add(CssId.LOGIN_TITLE);

        this.getStyleClass().add(CssId.VBOX);
        
        TableColumn numOrder = new TableColumn(Constants.HASH_KEY);
        numOrder.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ResidentialCommunity, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ResidentialCommunity, String> o) {
                return new ReadOnlyObjectWrapper(Controller.getInstance().getTemporaryList().getResidentialCommunitys().indexOf(o.getValue()) + 1 + "");
            }
        });
        numOrder.setMinWidth(30);

        TableColumn nameBuildingCol = new TableColumn(Constants.NAME_OF_BUILDING);
        nameBuildingCol.setMinWidth(213);
        nameBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("name"));

        TableColumn numBuildingCol = new TableColumn(Constants.NUMBER);
        numBuildingCol.setMinWidth(212);
        numBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("number"));

        TableColumn idNumBuildingCol = new TableColumn(Constants.ID_NUM);
        idNumBuildingCol.setMinWidth(212);
        idNumBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("identificationNumber"));

        TableColumn taxNumBuildingCol = new TableColumn(Constants.TAX_NUM_BUILDING);
        taxNumBuildingCol.setMinWidth(202);
        taxNumBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("taxIdentificationNumber"));

        TableColumn mailNumBuildingCol = new TableColumn(Constants.MAIL);
        mailNumBuildingCol.setMinWidth(202);
        mailNumBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("mail"));

        TableColumn cityNumBuildingCol = new TableColumn(Constants.CITY);
        cityNumBuildingCol.setMinWidth(207);
        cityNumBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("city"));

        reload();
        tableBuildings.getColumns().addAll(numOrder, nameBuildingCol, numBuildingCol, idNumBuildingCol, taxNumBuildingCol, mailNumBuildingCol, cityNumBuildingCol);
        getChildren().addAll(titleLbl, getSearch(), tableBuildings, getForm());

    }

    private HBox getSearch() {

        HBox hSearch = new HBox();
        hSearch.getStyleClass().add(CssId.HBOX_LIST_BUILDING_PANE);
        
        searchBuildingBtn.setOnAction(Controller.getInstance().getManagerEvent().getSearchBuildingEvent());
        searchBuildingBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getSearchBuildingEvent().searchBuildingEvent();
            }
        });
        hSearch.getChildren().addAll(searchBuildingFld, searchBuildingBtn);
        return hSearch;

    }

    private HBox getForm() {

        HBox hbox = new HBox();
        hbox.getStyleClass().add(CssId.HBOX_LIST_BUILDING_PANE);

        nameBuildingFld.setMaxWidth(200);
        nameBuildingFld.setPromptText(Constants.NAME_OF_BUILDING);

        numberBuildingFld.setMaxWidth(50);
        numberBuildingFld.setPromptText(Constants.NUMBER);

        idNumBuildingFld.setMaxWidth(100);
        idNumBuildingFld.setPromptText(Constants.ID_NUM);

        tidNumBuildingFld.setMaxWidth(100);
        tidNumBuildingFld.setPromptText(Constants.TAX_NUM_BUILDING);

        mailBuildingFld.setMaxWidth(200);
        mailBuildingFld.setPromptText(Constants.MAIL);

        cityBuildingFld.setMaxWidth(150);
        cityBuildingFld.setPromptText(Constants.CITY);

        addBuildingBtn.setOnAction(Controller.getInstance().getManagerEvent().getAddBuildingEvent());
        addBuildingBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getAddBuildingEvent().addBuildingEvent();
            }

        });

        removeBuildingBtn.setOnAction(Controller.getInstance().getManagerEvent().getRemoveBuildingEvent());
        removeBuildingBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getRemoveBuildingEvent();
            }

        });

        hbox.getChildren().addAll(nameBuildingFld, numberBuildingFld, cityBuildingFld, idNumBuildingFld, tidNumBuildingFld, mailBuildingFld, removeBuildingBtn, addBuildingBtn);
        return hbox;
    }

    public void clearAllFields() {
        nameBuildingFld.setText(Constants.EMPTY_STRING);
        numberBuildingFld.setText(Constants.EMPTY_STRING);
        idNumBuildingFld.setText(Constants.EMPTY_STRING);
        tidNumBuildingFld.setText(Constants.EMPTY_STRING);
        mailBuildingFld.setText(Constants.EMPTY_STRING);
        cityBuildingFld.setText(Constants.EMPTY_STRING);
    }

    public void reload() {
        if (!isSearch) {
            listBuildings = Controller.getInstance().getTemporaryList().getResidentialCommunitys();
        }
        tableBuildings.setItems(FXCollections.observableArrayList(listBuildings));
    }

    public TextField getNumberBuildingFld() {
        return numberBuildingFld;
    }

    public void setNumberBuildingFld(TextField numberBuildingFld) {
        this.numberBuildingFld = numberBuildingFld;
    }

    public TextField getNameBuildingFld() {
        return nameBuildingFld;
    }

    public TextField getIdNumBuildingFld() {
        return idNumBuildingFld;
    }

    public TextField getTidNumBuildingFld() {
        return tidNumBuildingFld;
    }

    public TextField getMailBuildingFld() {
        return mailBuildingFld;
    }

    public TextField getSearchBuildingFld() {
        return searchBuildingFld;
    }

    public boolean isIsSearch() {
        return isSearch;
    }

    public void setIsSearch(boolean isSearch) {
        this.isSearch = isSearch;
    }

    public void setListBuildings(List<ResidentialCommunity> listBuildings) {
        this.listBuildings = listBuildings;
    }

    public List<ResidentialCommunity> getListBuildings() {
        return listBuildings;
    }

    public TableView<ResidentialCommunity> getTableBuildings() {
        return tableBuildings;
    }

    public TextField getCityBuildingFld() {
        return cityBuildingFld;
    }

    public void setCityBuildingFld(TextField cityBuildingFld) {
        this.cityBuildingFld = cityBuildingFld;
    }

}
