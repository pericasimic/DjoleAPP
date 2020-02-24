package djoleapp.gui.maingui.occupantgui;

import djoleapp.business.model.Occupant;
import djoleapp.controller.constant.Constants;
import java.util.List;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class TableOccupant extends TableView<Occupant> {

    public TableOccupant() {
    }

    public TableOccupant(List<Occupant> list) {
        TableColumn numOrder = new TableColumn(Constants.HASH_KEY);
        numOrder.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Occupant, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Occupant, String> o) {
                return new ReadOnlyObjectWrapper(getItems().indexOf(o.getValue()) + 1 + "");
            }
        });
        numOrder.setSortable(false);

        TableColumn firstNameCol = new TableColumn(Constants.FIRST_NAME);
        firstNameCol.setMinWidth(150);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Occupant, String>("firstNameOccupant"));

        TableColumn lastNameCol = new TableColumn(Constants.LAST_NAME);
        lastNameCol.setMinWidth(150);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Occupant, String>("lastNameOccupant"));

        TableColumn idNumberCol = new TableColumn(Constants.ID_NUM);
        idNumberCol.setMinWidth(150);
        idNumberCol.setCellValueFactory(new PropertyValueFactory<Occupant, String>("identificationNumber"));

        TableColumn phoneNumberCol = new TableColumn(Constants.PHONE_NUMBER);
        phoneNumberCol.setMinWidth(150);
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Occupant, String>("phoneNumber"));

        TableColumn mailCol = new TableColumn(Constants.MAIL);
        mailCol.setMinWidth(150);
        mailCol.setCellValueFactory(new PropertyValueFactory<Occupant, String>("mail"));

        this.setItems(FXCollections.observableArrayList(list));
        this.getColumns().addAll(numOrder, firstNameCol, lastNameCol, idNumberCol, phoneNumberCol, mailCol);
    }

}
