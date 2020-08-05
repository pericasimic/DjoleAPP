package djoleapp.gui.maingui.occupantgui;

import djoleapp.business.model.BankAccount;
import djoleapp.business.model.Occupant;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class SelectOcupantPane extends BorderPane {

    private Label title = new Label();

    private TextField idFld = new TextField();
    private TextField idNumberFld = new TextField();
    private TextField phoneFld = new TextField();
    private TextField mailFld = new TextField();
    private TextField debitFld = new TextField();
    private TextArea noteFld = new TextArea();

    private Label id = new Label(Constants.ID);
    private Label idNumberLbl = new Label(Constants.ID_NUM);
    private Label phoneLbl = new Label(Constants.PHONE_NUMBER);
    private Label mailLbl = new Label(Constants.MAIL);
    private Label noteLbl = new Label(Constants.NOTE);
    private Label bankAccountsLbl = new Label(Constants.BANK_ACCOUNT);
    private Label selectListLbl = new Label(Constants.SELECT_LIST);
    private Label listBuildingsLbl = new Label(Constants.BUILDINGS_LIST_TITLE);
    private Label debitLbl = new Label(Constants.DEBIT);

    private ComboBox<BankAccount> accountsBox = new ComboBox<>();
    private ComboBox<String> selctBox = new ComboBox<>();

    private Button selectListBtn = new Button(Constants.BUTTON_SHOW);
    private Button back = new Button(Constants.BUTTON_BACK);
    private Button editBtn = new Button(Constants.BUTTON_EDIT);
    private Button addAccountBtn = new Button(Constants.BUTTON_ADD_ACCOUNT);

    public SelectOcupantPane(Occupant o) {

        Controller.getInstance().setTemporaryOccupant(o);

        title.setFont(new Font(Constants.FONT_ARIAL, 20));
        title.setText(Constants.INFO_OCCUPANT + " " + o.getFirstNameOccupant() + " " + o.getLastNameOccupant());
        this.setTop(title);

        GridPane gp = new GridPane();
        gp.setStyle(Constants.FX_BORDER_COLOR_BLACK);
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setAlignment(Pos.CENTER);

        gp.setVgap(5);
        gp.setHgap(5);

        gp.add(id, 0, 0);
        gp.add(idFld, 1, 0);
        gp.add(debitLbl, 0, 1);
        gp.add(debitFld, 1, 1);
        gp.add(idNumberLbl, 0, 2);
        gp.add(idNumberFld, 1, 2);
        gp.add(phoneLbl, 0, 3);
        gp.add(phoneFld, 1, 3);
        gp.add(mailLbl, 0, 4);
        gp.add(mailFld, 1, 4);
        gp.add(noteLbl, 0, 5);
        gp.add(noteFld, 1, 5);
        gp.add(bankAccountsLbl, 0, 6);
        gp.add(accountsBox, 1, 6);
        gp.add(addAccountBtn, 1, 7);
        gp.add(selectListLbl, 0, 8);
        gp.add(selctBox, 1, 8);
        gp.add(selectListBtn, 1, 9);

        idFld.setText(Long.toString(o.getId()));
        idFld.setEditable(false);
        debitFld.setText(Double.toString(o.getSum()));
        debitFld.setEditable(false);
        idNumberFld.setText(o.getIdentificationNumber());
        idNumberFld.setEditable(false);
        phoneFld.setText(o.getPhoneNumber());
        phoneFld.setEditable(false);
        mailFld.setText(o.getMail());
        mailFld.setEditable(false);
        noteFld.setText(o.getNote());
        noteFld.setEditable(false);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(3);
        hBox.setPadding(new Insets(10, 10, 10, 10));

        selctBox.getItems().addAll(Constants.SEPARATE_SECTIONS, Constants.INDEPENDENT_SECTIONS, Constants.STATEMENTS, Constants.ACCOUNTS);

        accountsBox.setItems(FXCollections.observableArrayList(Controller.getInstance().getTemporaryOccupant().getBankAccounts()));

        addAccountBtn.setOnAction(Controller.getInstance().getManagerEvent().getAddAccountOccupantEvent());
        addAccountBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getAddAccountOccupantEvent().addAccountOccupantEvent();
            }

        });

        selectListBtn.setOnAction(Controller.getInstance().getManagerEvent().getShowSelectListsOccupantEvent());
        selectListBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getShowSelectListsOccupantEvent().showSelectListsOccupantEvent();
            }

        });

        back.setOnAction(Controller.getInstance().getManagerEvent().getListOccupantEvent());
        back.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getListOccupantEvent().listOccupantEvent();
            }

        });

        editBtn.setOnAction(Controller.getInstance().getManagerEvent().getConfirmAddOcupantEvent());
        editBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getConfirmAddOcupantEvent().confirmAddOcupantEvent();
            }

        });

        hBox.getChildren().addAll(back, editBtn);

        this.setPadding(new Insets(60, 60, 60, 60));
        this.setCenter(gp);
        this.setBottom(hBox);
    }

    public TextField getIdFld() {
        return idFld;
    }

    public void setIdFld(TextField idFld) {
        this.idFld = idFld;
    }

    public TextField getIdNumberFld() {
        return idNumberFld;
    }

    public TextField getDebitFld() {
        return debitFld;
    }

    public void setDebitFld(TextField debitFld) {
        this.debitFld = debitFld;
    }

    public void setIdNumberFld(TextField idNumberFld) {
        this.idNumberFld = idNumberFld;
    }

    public TextField getPhoneFld() {
        return phoneFld;
    }

    public void setPhoneFld(TextField phoneFld) {
        this.phoneFld = phoneFld;
    }

    public TextField getMailFld() {
        return mailFld;
    }

    public void setMailFld(TextField mailFld) {
        this.mailFld = mailFld;
    }

    public TextArea getNoteFld() {
        return noteFld;
    }

    public void setNoteFld(TextArea noteFld) {
        this.noteFld = noteFld;
    }

    public ComboBox<String> getSelctBox() {
        return selctBox;
    }

}
