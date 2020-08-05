package djoleapp.gui.maingui.occupantgui;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AddOccupantPane extends BorderPane {
    
    private Label title = new Label(Constants.TITLE_ADD_OCCUPANT);
    
    private TextField firstNameFld = new TextField();
    private TextField lastNameFld = new TextField();
    private TextField idNumberFld = new TextField();
    private TextField phoneFld = new TextField();
    private TextField mailFld = new TextField();
    private TextArea noteFld = new TextArea();
    
    private Label firstNameLbl = new Label(Constants.FIRST_NAME);
    private Label lastNameLbl = new Label(Constants.LAST_NAME);
    private Label idNumberLbl = new Label(Constants.ID_NUM);
    private Label phoneLbl = new Label(Constants.PHONE_NUMBER);
    private Label mailLbl = new Label(Constants.MAIL);
    private Label noteLbl = new Label(Constants.NOTE);
    
    private Button confirmBtn = new Button(Constants.BUTTON_CONFIRM);
    private Button cancelBtn = new Button(Constants.BUTTON_CANCEL);
    
    public AddOccupantPane() {
        
        title.setFont(new Font(Constants.FONT_ARIAL, 20));
        this.setTop(title);
        
        GridPane gp = new GridPane();
        gp.setStyle(Constants.FX_BORDER_COLOR_BLACK);
        gp.setPadding(new Insets(10, 10, 10, 10));
        gp.setAlignment(Pos.CENTER);
        
        gp.setVgap(5);
        gp.setHgap(5);
        
        gp.add(firstNameLbl, 0, 0);
        gp.add(firstNameFld, 1, 0);
        gp.add(lastNameLbl, 0, 1);
        gp.add(lastNameFld, 1, 1);
        gp.add(idNumberLbl, 0, 2);
        gp.add(idNumberFld, 1, 2);
        gp.add(phoneLbl, 0, 3);
        gp.add(phoneFld, 1, 3);
        gp.add(mailLbl, 0, 4);
        gp.add(mailFld, 1, 4);
        gp.add(noteLbl, 0, 5);
        gp.add(noteFld, 1, 5);
        
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(3);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        
        confirmBtn.setOnAction(Controller.getInstance().getManagerEvent().getConfirmAddOcupantEvent());
        confirmBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getConfirmAddOcupantEvent().confirmAddOcupantEvent();
            }

        });
        
        cancelBtn.setOnAction(Controller.getInstance().getManagerEvent().getListOccupantEvent());
        cancelBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getListOccupantEvent().listOccupantEvent();
            }

        });
        
        hBox.getChildren().addAll(cancelBtn, confirmBtn);
        
        this.setPadding(new Insets(60, 60, 60, 60));
        this.setCenter(gp);
        this.setBottom(hBox);
    }

    public TextField getFirstNameFld() {
        return firstNameFld;
    }

    public TextField getLastNameFld() {
        return lastNameFld;
    }

    public TextField getIdNumberFld() {
        return idNumberFld;
    }

    public TextField getPhoneFld() {
        return phoneFld;
    }

    public TextField getMailFld() {
        return mailFld;
    }

    public TextArea getNoteFld() {
        return noteFld;
    }
    
    
}
