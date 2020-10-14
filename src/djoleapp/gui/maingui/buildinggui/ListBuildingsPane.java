package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.constant.CssId;
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

        setSpacing(5);
        setPadding(new Insets(10, 10, 10, 10));


        TableColumn nameBuildingCol = new TableColumn(Constants.NAME_OF_BUILDING);
        nameBuildingCol.setMinWidth(213);
        nameBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("name"));

        TableColumn numBuildingCol = new TableColumn(Constants.NUMBER);
        numBuildingCol.setMinWidth(213);
        numBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("number"));

        TableColumn idNumBuildingCol = new TableColumn(Constants.ID_NUM);
        idNumBuildingCol.setMinWidth(213);
        idNumBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("identificationNumber"));

        TableColumn taxNumBuildingCol = new TableColumn(Constants.TAX_NUM_BUILDING);
        taxNumBuildingCol.setMinWidth(213);
        taxNumBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("taxIdentificationNumber"));

        TableColumn mailNumBuildingCol = new TableColumn(Constants.MAIL);
        mailNumBuildingCol.setMinWidth(213);
        mailNumBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("mail"));

        TableColumn cityNumBuildingCol = new TableColumn(Constants.CITY);
        cityNumBuildingCol.setMinWidth(213);
        cityNumBuildingCol.setCellValueFactory(new PropertyValueFactory<ResidentialCommunity, String>("city"));

        reload();
        tableBuildings.getColumns().addAll(nameBuildingCol, numBuildingCol, idNumBuildingCol, taxNumBuildingCol, mailNumBuildingCol, cityNumBuildingCol);
        getChildren().addAll(titleLbl, getSearch(), tableBuildings, getForm());

    }

    private HBox getSearch() {

        HBox hSearch = new HBox();
        hSearch.setSpacing(3);
        hSearch.setPadding(new Insets(10, 10, 10, 10));
        hSearch.setAlignment(Pos.CENTER);

        searchBuildingFld.setMaxWidth(USE_PREF_SIZE);

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
        hbox.setSpacing(3);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setAlignment(Pos.CENTER);

        nameBuildingFld.setMaxWidth(USE_PREF_SIZE);
        nameBuildingFld.setPromptText(Constants.NAME_OF_BUILDING);

        numberBuildingFld.setMaxWidth(60);
        numberBuildingFld.setPromptText(Constants.NUMBER);

        idNumBuildingFld.setMaxWidth(80);
        idNumBuildingFld.setPromptText(Constants.ID_NUM);

        tidNumBuildingFld.setMaxWidth(80);
        tidNumBuildingFld.setPromptText(Constants.TAX_NUM_BUILDING);

        mailBuildingFld.setMaxWidth(USE_PREF_SIZE);
        mailBuildingFld.setPromptText(Constants.MAIL);

        cityBuildingFld.setMaxWidth(USE_PREF_SIZE);
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
