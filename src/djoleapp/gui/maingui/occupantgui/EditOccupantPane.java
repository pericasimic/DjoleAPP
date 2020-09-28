package djoleapp.gui.maingui.occupantgui;

import djoleapp.business.model.Occupant;
import djoleapp.controller.constant.Constants;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class EditOccupantPane extends BorderPane {

    private Label titleLbl = new Label();

    private Label nameLbl = new Label(Constants.FIRST_NAME);
    private Label lastNameLbl = new Label(Constants.LAST_NAME);
    private Label idNumberLbl = new Label(Constants.ID_NUM);
    private Label phoneLbl = new Label(Constants.PHONE_NUMBER);
    private Label mailLbl = new Label(Constants.MAIL);
    private Label noteLbl = new Label(Constants.NOTE);

    private TextField nameFld = new TextField();
    private TextField lastNameFld = new TextField();
    private TextField idNumberFld = new TextField();
    private TextField phoneFld = new TextField();
    private TextField mailFld = new TextField();
    private TextArea noteFld = new TextArea();

    private Button editBtn = new Button(Constants.BUTTON_EDIT);
    private Button backBtn = new Button(Constants.BUTTON_CANCEL);

    public EditOccupantPane(Occupant occupant) {

        GridPane gridPane = new GridPane();
        
        gridPane.add(nameLbl, 0, 1);
        gridPane.add(nameFld, 1, 1);
        gridPane.add(lastNameLbl, 0, 2);
        gridPane.add(lastNameFld, 1, 2);
        gridPane.add(idNumberLbl, 0, 3);
        gridPane.add(idNumberFld, 1, 3);
        gridPane.add(phoneLbl, 0, 4);
        gridPane.add(phoneFld, 1, 4);
        gridPane.add(mailLbl, 0, 5);
        gridPane.add(mailFld, 1, 5);
        gridPane.add(noteLbl, 0, 6);
        gridPane.add(noteFld, 1, 6);
        
        titleLbl.setText(Constants.EDIT_OCCUPANT + occupant.getFirstNameOccupant()+" "+ occupant.getLastNameOccupant());
        nameFld.setText(occupant.getFirstNameOccupant());
        lastNameFld.setText(occupant.getLastNameOccupant());
        idNumberFld.setText(occupant.getIdentificationNumber());
        phoneFld.setText(occupant.getPhoneNumber());
        mailFld.setText(occupant.getMail());
        noteFld.setText(occupant.getNote());
        
        HBox hBox = new HBox();
        hBox.getChildren().addAll(backBtn, editBtn);
        
        this.setTop(titleLbl);
        this.setCenter(gridPane);
        this.setBottom(hBox);
        
    }

    public TextField getNameFld() {
        return nameFld;
    }

    public void setNameFld(TextField nameFld) {
        this.nameFld = nameFld;
    }

    public TextField getLastNameFld() {
        return lastNameFld;
    }

    public void setLastNameFld(TextField lastNameFld) {
        this.lastNameFld = lastNameFld;
    }

    public TextField getIdNumberFld() {
        return idNumberFld;
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

    
    
}
