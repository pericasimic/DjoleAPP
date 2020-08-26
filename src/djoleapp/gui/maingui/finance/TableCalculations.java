package djoleapp.gui.maingui.finance;

import djoleapp.business.model.AccountCalculation;
import djoleapp.business.model.Flat;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.constant.Constants;
import java.util.List;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class TableCalculations extends TableView<AccountCalculation>{

    public TableCalculations(List<AccountCalculation> list) {
        
        TableColumn numOrder = new TableColumn(Constants.HASH_KEY);
        numOrder.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<AccountCalculation, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<AccountCalculation, String> o) {
                return new ReadOnlyObjectWrapper(getItems().indexOf(o.getValue()) + 1 + "");
            }
        });
        numOrder.setSortable(false);

        TableColumn buildingCol = new TableColumn(Constants.BUILDING);
        buildingCol.setMinWidth(150);
        buildingCol.setCellValueFactory(new PropertyValueFactory<AccountCalculation, ResidentialCommunity>("residentialCommunity"));

        TableColumn ownerCol = new TableColumn(Constants.OWNER);
        ownerCol.setMinWidth(150);
        ownerCol.setCellValueFactory(new PropertyValueFactory<AccountCalculation, Occupant>("occupant"));

        TableColumn monthCol = new TableColumn(Constants.MONTH);
        monthCol.setMinWidth(150);
        monthCol.setCellValueFactory(new PropertyValueFactory<AccountCalculation, String>("month"));

        TableColumn numberCol = new TableColumn(Constants.NUMBER_CALCULATION);
        numberCol.setMinWidth(150);
        numberCol.setCellValueFactory(new PropertyValueFactory<AccountCalculation, String>("titleNumber"));

        TableColumn sumCol = new TableColumn(Constants.SUM_CALCULATION);
        sumCol.setMinWidth(150);
        sumCol.setCellValueFactory(new PropertyValueFactory<AccountCalculation, Double>("debitCurentMonth"));
        

        this.setItems(FXCollections.observableArrayList(list));
        this.getColumns().addAll(numOrder, buildingCol, ownerCol, monthCol, numberCol, sumCol);
        
    }
  
}
