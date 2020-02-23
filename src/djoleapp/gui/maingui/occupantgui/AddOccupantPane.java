package djoleapp.gui.maingui.occupantgui;

import djoleapp.controller.constant.Constants;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AddOccupantPane extends GridPane {
    
    private TextField firstNameFld = new TextField();
    private TextField lastNameFld = new TextField();
    private TextField idNumberFld = new TextField();
    private TextField phoneFld = new TextField();
    private TextField mailFld = new TextField();
    private Text noteFld = new Text();
    
    private Label firstNameLbl = new Label(Constants.FIRST_NAME);
    private Label lastNameLbl = new Label(Constants.LAST_NAME);
    private Label idNumberLbl = new Label(Constants.ID_NUM);
    private Label phoneLbl = new Label(Constants.PHONE_NUMBER);
    private Label mailLbl = new Label(Constants.MAIL);
    private Label noteLbl = new Label(Constants.NOTE);
    
    private Button confirmBtn = new Button(Constants.BUTTON_CONFIRM);
    private Button cancelBtn = new Button(Constants.BUTTON_CANCEL);
}
