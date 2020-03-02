package djoleapp.gui.maingui.occupantgui;

import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ListOccupantsPane extends VBox {

    private Label titleLbl = new Label(Constants.OCCUPANT_LIST_TITLE);
    private TableOccupant tableOccupant = new TableOccupant();

    private TextField searchOccupantFld = new TextField();

    private Button addOccupantBtn = new Button(Constants.BUTTON_ADD);
    private Button removeOccupantBtn = new Button(Constants.BUTTON_REMOVE);
    private Button serchOccupantBtn = new Button(Constants.BUTTON_SEARCH);

    public ListOccupantsPane() {
        titleLbl.setFont(new Font(Constants.FONT_ARIAL, 20));
        setSpacing(5);
        setPadding(new Insets(10, 10, 10, 10));

        tableOccupant = new TableOccupant(Controller.getInstance().getTemporaryList().getOccupants());

        tableOccupant.setRowFactory(tv -> {
            TableRow<Occupant> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Occupant rowData = row.getItem();
                    Controller.getInstance().getManagerEvent().getSelectOccupantEvent().selectOccupantEvent(rowData);
                }
            });
            return row;
        });

        Controller.getInstance().setTableOccupant(tableOccupant);

        getChildren().addAll(titleLbl, getSearch(), tableOccupant, getForm());

    }

    private HBox getSearch() {

        HBox hSearch = new HBox();
        hSearch.setSpacing(3);
        hSearch.setPadding(new Insets(10, 10, 10, 10));
        hSearch.setAlignment(Pos.CENTER);

        searchOccupantFld.setMaxWidth(USE_PREF_SIZE);

//        searchBuildingBtn.setOnAction(Controller.getInstance().getManagerEvent().getSearchUserEvent());
//        searchBuildingBtn.setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.ENTER) {
//                Controller.getInstance().getManagerEvent().getSearchUserEvent().searchUserEvent();
//            }
//        });
        hSearch.getChildren().addAll(searchOccupantFld, serchOccupantBtn);
        return hSearch;

    }

    private HBox getForm() {

        HBox hbox = new HBox();
        hbox.setSpacing(3);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setAlignment(Pos.CENTER);

        addOccupantBtn.setOnAction(Controller.getInstance().getManagerEvent().getAddOccupantEvent());
        addOccupantBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getAddOccupantEvent().addOccupantEvent();
            }

        });

//        removeBtn.setOnAction(Controller.getInstance().getManagerEvent().getRemoveUserEvent());
//        removeBtn.setOnKeyPressed(e -> {
//            if (e.getCode() == KeyCode.ENTER) {
//                Controller.getInstance().getManagerEvent().getRemoveUserEvent().removeUserEvent();
//            }
//
//        });
        hbox.getChildren().addAll(removeOccupantBtn, addOccupantBtn);
        return hbox;
    }
//    
//    public void clearAllFields() {
//        nameBuildingFld.setText(Constants.EMPTY_STRING);
//        idNumBuildingFld.setText(Constants.EMPTY_STRING);
//        tidNumBuildingFld.setText(Constants.EMPTY_STRING);
//        mailBuildingFld.setText(Constants.EMPTY_STRING);
//    }
//

    public void reload() {
        tableOccupant.setItems(FXCollections.observableArrayList(Controller.getInstance().getTemporaryList().getOccupants()));
    }

}
