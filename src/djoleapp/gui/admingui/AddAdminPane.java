package djoleapp.gui.admingui;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AddAdminPane extends BorderPane {

    private final Text titleAddAdmin = new Text(Constants.TITLE_ADD_ADMIN);
    private final Label addUsernameLbl = new Label(Constants.USERNAME_LBL);
    private final Label addPasswordLbl = new Label(Constants.PASSWORD_LBL);
    private final Label confirmPasswordLbl = new Label(Constants.ADD_ADMIN_LABEL_PASSWORD_CONFIRM);

    private TextField addUsernameFld = new TextField();
    private PasswordField addPasswordFld = new PasswordField();
    private PasswordField confirmPasswordFld = new PasswordField();

    private Button confirmBtn = new Button(Constants.BUTTON_CONFIRM);
    private Button logoutBtn = new Button(Constants.BUTTON_LOGOUT);

    public AddAdminPane() {
        HBox hBox = new HBox();
        hBox.setMargin(titleAddAdmin, new Insets(0, 0, 100, 0));
        hBox.setAlignment(Pos.CENTER);
        titleAddAdmin.setFill(Color.BLUE);
        titleAddAdmin.setFont(new Font(Constants.FONT_COMIC_SANS, 18));
        hBox.getChildren().add(titleAddAdmin);
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle(Constants.FX_BORDER_COLOR_BLACK);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(addUsernameLbl, 0, 0);
        gridPane.add(addUsernameFld, 1, 0);
        gridPane.add(addPasswordLbl, 0, 1);
        gridPane.add(addPasswordFld, 1, 1);
        gridPane.add(confirmPasswordLbl, 0, 2);
        gridPane.add(confirmPasswordFld, 1, 2);
        
        HBox hBox2 = new HBox(20); 
        hBox2.getChildren().addAll(logoutBtn, confirmBtn);
        gridPane.add(hBox2, 1, 3);
        
        confirmBtn.setOnAction(Controller.getInstance().getManagerEvent().getAddAdminEvent());
        confirmBtn.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                Controller.getInstance().getManagerEvent().getAddAdminEvent().addAdminEvent();
            }
        });
        
        logoutBtn.setOnAction(Controller.getInstance().getManagerEvent().getLogoutEvent());
        logoutBtn.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                Controller.getInstance().getManagerEvent().getLogoutEvent().logoutEvent();
            }
        });

        this.setPadding(new Insets(200,200,200,200));
        this.setTop(hBox);
        this.setCenter(gridPane);

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
