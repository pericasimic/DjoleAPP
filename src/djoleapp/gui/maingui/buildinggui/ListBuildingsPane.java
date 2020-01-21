package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ListBuildingsPane extends VBox {

    private Label titleLbl = new Label(Constants.MENU_ITEM_BUILDING_LIST);
    private TableView<ResidentialCommunity> tableBuildings = new TableView<>();
    private List<ResidentialCommunity> listBuildings = null;

    private TextField nameBuildingFld = new TextField();
    private TextField idNumBuildingFld = new TextField();
    private TextField tidNumBuildingFld = new TextField();
    private TextField mailBuildingFld = new TextField();
    private TextField searchBuildingFld = new TextField();

    private Button addBuildingBtn = new Button(Constants.BUTTON_ADD);
    private Button removeBuildingBtn = new Button(Constants.BUTTON_REMOVE);
    private Button searchBuildingBtn = new Button(Constants.BUTTON_SEARCH);

    public ListBuildingsPane() {
        titleLbl.setFont(new Font(Constants.FONT_ARIAL, 20));
        setSpacing(5);
        setPadding(new Insets(10, 10, 10, 10));
        
        loadBuildings();
        
        TableColumn nameBuildingCol = new TableColumn(Constants.NAME_OF_BUILDING);

    }

    public void loadBuildings() {
        listBuildings = Controller.getInstance().getTemporaryList().getResidentialCommunitys();
    }

    public TableView<ResidentialCommunity> getTableBuildings() {
        return tableBuildings;
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
    
    

}
