package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.BankAccount;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;

public class BankDetailsBildingPane extends VBox {

    private Label selectBuildingLbl = new Label(Constants.SELECT_BUILDINGS);
    private Label selectItemLbl = new Label(Constants.SELECT_ITEM);
    private Label showLbl = new Label();

    private TableView<BankAccount> bankAccountTable = new TableView<>();
    private TextField nameBankFld = new TextField();
    private TextField numAccountFld = new TextField();
    private Button addAccountBtn = new Button(Constants.BUTTON_ADD);

    private ComboBox<ResidentialCommunity> buildingsBox = new ComboBox<>();
    private ComboBox<String> selectItemBox = new ComboBox<>();

    private Button showBtn = new Button(Constants.BUTTON_SHOW);

    public BankDetailsBildingPane() {
        this.getChildren().addAll(getSelectList());
        this.setPadding(new Insets(10, 10, 10, 10));
    }

    public BankDetailsBildingPane(List<BankAccount> bankAccounts) {
        this.setPadding(new Insets(10, 10, 10, 10));

        TableColumn nameBankCol = new TableColumn(Constants.BANK);
        nameBankCol.setMinWidth(150);
        nameBankCol.setCellValueFactory(new PropertyValueFactory<BankAccount, String>("bankName"));

        TableColumn numAccountCol = new TableColumn(Constants.BANK_ACCOUNT);
        numAccountCol.setMinWidth(150);
        numAccountCol.setCellValueFactory(new PropertyValueFactory<BankAccount, String>("bankAccountNumber"));

        bankAccountTable.setItems(FXCollections.observableArrayList(bankAccounts));
        bankAccountTable.getColumns().addAll(nameBankCol, numAccountCol);

        HBox hbox = new HBox();
        hbox.setSpacing(3);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setAlignment(Pos.CENTER);
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

        hbox.getChildren().addAll(nameBankFld, numAccountFld, addAccountBtn);
        this.getChildren().addAll(getSelectList(), bankAccountTable, hbox);

    }

    private HBox getSelectList() {

        HBox hSelect = new HBox();
        hSelect.setSpacing(50);
        hSelect.setStyle(Constants.FX_BORDER_COLOR_BLACK);
        hSelect.setPadding(new Insets(10, 10, 10, 10));
        hSelect.setAlignment(Pos.CENTER);

        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(selectBuildingLbl, buildingsBox);

        VBox vBox2 = new VBox();
        vBox2.setSpacing(10);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.getChildren().addAll(selectItemLbl, selectItemBox);

        VBox vBox3 = new VBox();
        vBox3.setSpacing(10);
        vBox3.setAlignment(Pos.CENTER);
        vBox3.getChildren().addAll(showLbl, showBtn);

        buildingsBox.setMaxWidth(USE_PREF_SIZE);
        buildingsBox.setItems(FXCollections.observableArrayList(Controller.getInstance().getTemporaryList().getResidentialCommunitys()));

        selectItemBox.setMaxWidth(USE_PREF_SIZE);
        selectItemBox.getItems().addAll(Constants.BANK_ACCOUNT, Constants.STATEMENTS, Constants.ACCOUNT_CALCULATION);

        showBtn.setMaxWidth(USE_PREF_SIZE);

        showBtn.setOnAction(Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent());
        showBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent().showSelectBuildTableEvent();
            }
        });

        hSelect.getChildren().addAll(vBox1, vBox2, vBox3);
        return hSelect;

    }

    public void reloadBankAccountTable(List<BankAccount> list) {
        bankAccountTable.setItems(FXCollections.observableArrayList(list));
    }

    public ComboBox<ResidentialCommunity> getBuildingsBox() {
        return buildingsBox;
    }

    public ComboBox<String> getSelectItemBox() {
        return selectItemBox;
    }

    public void setBankAccountTable(TableView<BankAccount> bankAccountTable) {
        this.bankAccountTable = bankAccountTable;
    }

    public TextField getNameBankFld() {
        return nameBankFld;
    }

    public TextField getNumAccountFld() {
        return numAccountFld;
    }

}
