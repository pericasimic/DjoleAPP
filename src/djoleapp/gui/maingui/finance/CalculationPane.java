package djoleapp.gui.maingui.finance;

import djoleapp.business.Factory;
import djoleapp.business.model.AccountCalculation;
import djoleapp.business.model.PaymentItems;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CalculationPane extends BorderPane {

    private final Label nameOfBuildingLbl = new Label();
    private final Label cityOfBuildingLbl = new Label();
    private final Label taxIdBuildingNumberLbl = new Label();
    private final Label identificationNumberLbl = new Label();
    private final Label ownerBuildingLbl = new Label();
    private final Label idOwnerLbl = new Label();
    private final Label yearMonthLbl = new Label();
    private final Label calculateNumberLbl = new Label();
    private final Label dateOfDeliveryLbl = new Label();
    private final Label paymentDeadlineLbl = new Label();
    private final Label debitCurentMonthLbl = new Label();
    private final Label debitPreviousMonthLbl = new Label();
    private final Label sumLbl = new Label();
    private Button changeBtn = new Button(Constants.BUTTON_EDIT);
    private Button pdfBtn = new Button(Constants.EXPORT_TO_PDF);
    LocalDate localDate;

    private final TableView<PaymentItems> tableItems;

    public CalculationPane(AccountCalculation ac) {

        Controller.getInstance().setTemporaryAccountCalculation(ac);
        tableItems = tableMaintenance(ac.getItemses());
        localDate = ac.getDateOfDelivery().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        nameOfBuildingLbl.setText(ac.getResidentialCommunity().getName());
        cityOfBuildingLbl.setText(ac.getResidentialCommunity().getCity());
        taxIdBuildingNumberLbl.setText("PIB: " + ac.getResidentialCommunity().getTaxIdentificationNumber());
        identificationNumberLbl.setText("Matični broj: " + ac.getResidentialCommunity().getIdentificationNumber());
        ownerBuildingLbl.setText(ac.getOccupant().getFirstNameOccupant() + " " + ac.getOccupant().getLastNameOccupant());
        idOwnerLbl.setText("ID korisnika: " + String.valueOf(ac.getOccupant().getId()));
        yearMonthLbl.setText(Constants.ACCOUNT_CALCULATION_FOR + Factory.getFacade().returnMonth(localDate.getMonthValue()) + " " + localDate.getYear());
        calculateNumberLbl.setText("Broj računa: " + ac.getCalculationNumber());
        dateOfDeliveryLbl.setText(Constants.DATE_DELIVERY + " " + Factory.getFacade().getDateFormat(ac.getDateOfDelivery()));
        paymentDeadlineLbl.setText(Constants.DATE_DEADLINE + " " + Factory.getFacade().getDateFormat(ac.getPaymentDeadline()));
        debitCurentMonthLbl.setText(Constants.DEBIT_FOR + " " + Factory.getFacade().returnMonth(localDate.getMonthValue()) + " " + localDate.getYear() + ": " + ac.getDebitCurentMonth());
        debitPreviousMonthLbl.setText(Constants.DEBIT + " " + Constants.FROM_PREVIOUS_PERIOD + ": " + ac.getDebitPreviousMonth());
        sumLbl.setText(Constants.SUM_ALL + ": " + ac.getSum());

        this.setTop(yearMonthLbl);
        this.setAlignment(yearMonthLbl, Pos.CENTER);
        this.setPadding(new Insets(30, 30, 30, 30));
        this.setMargin(yearMonthLbl, new Insets(30, 30, 30, 30));

        VBox vBox = new VBox();
        vBox.setSpacing(3);
        vBox.setPadding(new Insets(10, 10, 10, 10));

        vBox.getChildren().addAll(nameOfBuildingLbl, cityOfBuildingLbl, taxIdBuildingNumberLbl, identificationNumberLbl);
        this.setLeft(vBox);

        VBox vBox1 = new VBox();
        vBox1.setSpacing(3);
        vBox1.setPadding(new Insets(10, 10, 10, 10));

        vBox1.getChildren().addAll(ownerBuildingLbl, idOwnerLbl);
        this.setRight(vBox1);
        
        VBox vBox2 = new VBox();
        vBox2.setSpacing(3);
        vBox2.setPadding(new Insets(10, 10, 10, 10));
        
        vBox2.getChildren().addAll(calculateNumberLbl, dateOfDeliveryLbl, paymentDeadlineLbl, tableItems, debitCurentMonthLbl, debitPreviousMonthLbl, sumLbl);
        this.setCenter(vBox2);
        
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(3);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.getChildren().addAll(changeBtn, pdfBtn);
        
        pdfBtn.setOnAction(Controller.getInstance().getManagerEvent().getCreatePdfCalculaionEvent());
        pdfBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getCreatePdfCalculaionEvent().createPdfCalEvent();
            }
        });
        
        this.setBottom(hBox);

    }

    public TableView<PaymentItems> tableMaintenance(List<PaymentItems> list) {

        TableView<PaymentItems> table = new TableView<>();

        TableColumn listItemCol = new TableColumn(Constants.LIST_ITEM);
        listItemCol.setMinWidth(USE_PREF_SIZE);
        listItemCol.setCellValueFactory(new PropertyValueFactory<PaymentItems, String>("item"));

        TableColumn sumItemCol = new TableColumn(Constants.PRICE_PER_MONTH);
        sumItemCol.setMinWidth(USE_PREF_SIZE);
        sumItemCol.setCellValueFactory(new PropertyValueFactory<PaymentItems, Double>("sum"));

        table.setItems(FXCollections.observableArrayList(list));
        table.getColumns().addAll(listItemCol, sumItemCol);

        return table;
    }

}
