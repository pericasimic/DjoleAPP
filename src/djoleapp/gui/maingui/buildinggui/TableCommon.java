package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.CommonSection;
import djoleapp.business.model.IndependentSection;
import djoleapp.controller.constant.Constants;
import java.util.List;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class TableCommon extends TableView<CommonSection> {

    public TableCommon(List<CommonSection> list) {

        TableColumn numOrder = new TableColumn(Constants.HASH_KEY);
        numOrder.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CommonSection, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<CommonSection, String> o) {
                return new ReadOnlyObjectWrapper(getItems().indexOf(o.getValue()) + 1 + "");
            }
        });
        numOrder.setSortable(false);

        TableColumn nameCol = new TableColumn(Constants.NAME_OF_SECTION);
        nameCol.setMinWidth(150);
        nameCol.setCellValueFactory(new PropertyValueFactory<IndependentSection, String>("name"));

        TableColumn priceCol = new TableColumn(Constants.PRICE_PER_MONTH);
        priceCol.setMinWidth(150);
        priceCol.setCellValueFactory(new PropertyValueFactory<IndependentSection, Double>("pricePerMonth"));

        this.setItems(FXCollections.observableArrayList(list));
        this.getColumns().addAll(numOrder, nameCol, priceCol);
        
    }

}
