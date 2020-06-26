package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.BusinessSpace;
import djoleapp.business.model.Flat;
import djoleapp.business.model.Garage;
import djoleapp.business.model.IndependentSection;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ParkingBox;
import djoleapp.business.model.ParkingSpace;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.constant.Constants;
import java.util.List;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class TableSection extends TableView<SeparateSection> {

    public TableSection() {
    }

    public TableSection(List<SeparateSection> list) {
        TableColumn numOrder = new TableColumn(Constants.HASH_KEY);
        numOrder.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SeparateSection, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SeparateSection, String> o) {
                return new ReadOnlyObjectWrapper(getItems().indexOf(o.getValue()) + 1 + "");
            }
        });
        numOrder.setSortable(false);

        TableColumn kindCol = new TableColumn(Constants.KIND_SECTION);
        kindCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<SeparateSection, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<SeparateSection, String> o) {
                return new ReadOnlyObjectWrapper(valueString(o.getValue()));
            }
        });

        TableColumn numberCol = new TableColumn(Constants.NUMBER);
        numberCol.setMinWidth(150);
        numberCol.setCellValueFactory(new PropertyValueFactory<SeparateSection, Integer>("number"));

        TableColumn areaCol = new TableColumn(Constants.FLAT_AREA);
        areaCol.setMinWidth(150);
        areaCol.setCellValueFactory(new PropertyValueFactory<SeparateSection, Double>("surfaceArea"));

        TableColumn ownerCol = new TableColumn(Constants.OWNER);
        ownerCol.setMinWidth(150);
        ownerCol.setCellValueFactory(new PropertyValueFactory<SeparateSection, Occupant>("owner"));

        this.setItems(FXCollections.observableArrayList(list));
        this.getColumns().addAll(numOrder, kindCol, numberCol, areaCol, ownerCol);
    }

    private String valueString(SeparateSection ss) {
        if (ss instanceof Flat) {
            return Constants.FLAT;
        }
        if (ss instanceof BusinessSpace) {
            return Constants.BUSINESS_SPACE;
        }
        if (ss instanceof Garage) {
            return Constants.GARAGE;
        }
        if (ss instanceof ParkingSpace) {
            return Constants.GARAGE_SPACE;
        }
        if (ss instanceof ParkingBox) {
            return Constants.GARAGE_BOX;
        }
        return Constants.EMPTY_STRING;
    }
}
