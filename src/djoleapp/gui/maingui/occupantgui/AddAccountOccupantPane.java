package djoleapp.gui.maingui.occupantgui;


import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddAccountOccupantPane extends VBox {

    private Label nameOfBankLbl = new Label(Constants.BANK);
    private Label numberLbl = new Label(Constants.BANK_ACCOUNT);

    private TextField nameOfBankFld = new TextField();
    private TextField numberFld = new TextField();

    private Button addBtn = new Button(Constants.BUTTON_ADD);
    private Button cancelBtn = new Button(Constants.BUTTON_CANCEL);

    public AddAccountOccupantPane() {

        HBox hBox1 = new HBox();
        hBox1.setSpacing(3);
        hBox1.setPadding(new Insets(10, 10, 10, 10));
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(nameOfBankLbl, nameOfBankFld);

        HBox hBox2 = new HBox();
        hBox2.setSpacing(3);
        hBox2.setPadding(new Insets(10, 10, 10, 10));
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(numberLbl, numberFld);

        HBox hBox3 = new HBox();
        hBox3.setSpacing(3);
        hBox3.setPadding(new Insets(10, 10, 10, 10));
        hBox3.setAlignment(Pos.CENTER);
        hBox3.getChildren().addAll(cancelBtn, addBtn);

        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
        getChildren().addAll(hBox1, hBox2, hBox3);
        
        addBtn.setOnAction(Controller.getInstance().getManagerEvent().getConfirmAddAccountOccupantEvent());
        addBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getConfirmAddAccountOccupantEvent().confirmAddAccountOccupantEvent();
            }

        });
        
        cancelBtn.setOnAction(Controller.getInstance().getManagerEvent().getBackAddAccountOccupantEvent());
        cancelBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getBackAddAccountOccupantEvent().backAddAccountOccupantEvent();
            }

        });


    }
    
    

    public TextField getNameOfBankFld() {
        return nameOfBankFld;
    }

    public TextField getNumberFld() {
        return numberFld;
    }

    public void setNameOfBankFld(TextField nameOfBankFld) {
        this.nameOfBankFld = nameOfBankFld;
    }

    public void setNumberFld(TextField numberFld) {
        this.numberFld = numberFld;
    }
    
    

}
