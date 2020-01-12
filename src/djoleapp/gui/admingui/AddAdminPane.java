package djoleapp.gui.admingui;

import djoleapp.controller.constant.Constants;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 *
 * @author perica.simic
 */
public class AddAdminPane extends BorderPane {

    private final Text titleAddAdmin = new Text(Constants.TITLE_ADD_ADMIN);
    private final Label addUsernameLbl = new Label(Constants.USERNAME_LBL);
    private final Label addPasswordLbl = new Label(Constants.PASSWORD_LBL);
    private final Label confirmPasswordLbl = new Label(Constants.ADD_ADMIN_LABEL_PASSWORD_CONFIRM);
    
    private TextField addUsernameFld = new TextField();
    private PasswordField addPasswordFld = new PasswordField();
    private PasswordField confirmPasswordFld = new PasswordField();
    
    private Button loginBtn = new Button(Constants.BUTTON_CONFIRM);
    private Button logoutBtn = new Button(Constants.BUTTON_LOGOUT);
    
    
    public AddAdminPane(){
        
    }

    public PasswordField getAddPasswordFld() {
        return addPasswordFld;
    }

    public TextField getAddUsernameFld() {
        return addUsernameFld;
    }

    public PasswordField getConfirmPasswordFld() {
        return confirmPasswordFld;
    }
    
    
    
}
