package djoleapp.gui.maingui.finance;

import djoleapp.business.model.AccountCalculation;
import djoleapp.business.model.PaymentItems;
import djoleapp.controller.constant.Constants;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
public class CalculationPane extends VBox {

    private Label nameOfBuildingLbl = new Label();
    private Label cityOfBuildingLbl = new Label();
    private Label taxIdBuildingNumberLbl = new Label();
    private Label identificationNumberLbl = new Label();
    private Label ownerBuildingLbl = new Label();
    private Label numberSectionLbl = new Label();
    private Label yearMonthLbl = new Label();
    private Label calculateNumberLbl = new Label();
    private Label dateOfDeliveryLbl = new Label();
    private Label paymentDeadlineLbl = new Label();
    private Label debitCurentMonthLbl = new Label();
    private Label debitPreviousMonthLbl = new Label();
    private Label sumLbl = new Label();

    private TableView<PaymentItems> tableItems;

    public CalculationPane(AccountCalculation accountCalculation) {

        tableItems = tableMaintenance(accountCalculation.getItemses());

    }

    public TableView<PaymentItems> tableMaintenance(List<PaymentItems> list) {

        TableView<PaymentItems> table = new TableView<>();

        TableColumn listItemCol = new TableColumn(Constants.LIST_ITEM);
        listItemCol.setMinWidth(150);
        listItemCol.setCellValueFactory(new PropertyValueFactory<PaymentItems, String>("item"));

        TableColumn sumItemCol = new TableColumn(Constants.PRICE_PER_MONTH);
        sumItemCol.setMinWidth(150);
        sumItemCol.setCellValueFactory(new PropertyValueFactory<PaymentItems, Double>("sum"));

        table.setItems(FXCollections.observableArrayList(list));
        table.getColumns().addAll(listItemCol, sumItemCol);

        return table;
    }

}
