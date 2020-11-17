package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.BankAccount;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.constant.CssId;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;

public class BankDetailsBildingPane extends VBox {

    private TableView<BankAccount> bankAccountTable = new TableView<>();
    private TextField nameBankFld = new TextField();
    private TextField numAccountFld = new TextField();
    private final Button addAccountBtn = new Button(Constants.BUTTON_ADD);
    private final Button removeAccountBtn = new Button(Constants.BUTTON_REMOVE);

    public BankDetailsBildingPane(List<BankAccount> bankAccounts, HBox box) {
        this.setPadding(new Insets(10, 10, 10, 10));

        TableColumn nameBankCol = new TableColumn(Constants.BANK);
        nameBankCol.setMinWidth(640);
        nameBankCol.setCellValueFactory(new PropertyValueFactory<BankAccount, String>("bankName"));

        TableColumn numAccountCol = new TableColumn(Constants.BANK_ACCOUNT);
        numAccountCol.setMinWidth(640);
        numAccountCol.setCellValueFactory(new PropertyValueFactory<BankAccount, String>("bankAccountNumber"));

        bankAccountTable.setItems(FXCollections.observableArrayList(bankAccounts));
        bankAccountTable.getColumns().addAll(nameBankCol, numAccountCol);

        HBox hbox = new HBox();
        hbox.getStyleClass().add(CssId.HBOX_BANK_DETAILS_BUILD_PANE);
        nameBankFld.setMaxWidth(USE_PREF_SIZE);
        nameBankFld.setPromptText(Constants.BANK);

        numAccountFld.setMaxWidth(USE_PREF_SIZE);
        numAccountFld.setPromptText(Constants.BANK_ACCOUNT);

        addAccountBtn.setOnAction(Controller.getInstance().getManagerEvent().getAddBankAccountBuildEvent());
        addAccountBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getAddBankAccountBuildEvent().addBankAccountEvent();
            }

        });

        removeAccountBtn.setOnAction(Controller.getInstance().getManagerEvent().getRemoveBankAccountEvent());
        removeAccountBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getRemoveBankAccountEvent().removeBankAccountEvent();
            }

        });

        hbox.getChildren().addAll(nameBankFld, numAccountFld, removeAccountBtn, addAccountBtn);
        this.getChildren().addAll(box, bankAccountTable, hbox);

    }

    public void reloadBankAccountTable(List<BankAccount> list) {
        bankAccountTable.setItems(FXCollections.observableArrayList(list));
    }

    public TextField getNameBankFld() {
        return nameBankFld;
    }

    public TextField getNumAccountFld() {
        return numAccountFld;
    }

    public TableView<BankAccount> getBankAccountTable() {
        return bankAccountTable;
    }

}
