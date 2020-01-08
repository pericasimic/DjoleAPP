package djoleapp.gui;

import djoleapp.controller.constant.Constants;
import javafx.geometry.Insets;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class LoginPane extends BorderPane {

    private final Text loginTitle = new Text(Constants.TITLE_LOGIN);
    private final Label usernameLbl = new Label(Constants.USERNAME_LBL);
    private final Label passwordLbl = new Label(Constants.PASSWORD_LBL);
    private  TextField usernameFld = new TextField();
    private  PasswordField passwordFld = new PasswordField();
    private final Button loginBtn = new Button(Constants.BUTTON_LOGIN);
    private final Button logoutBtn = new Button(Constants.BUTTON_LOGOUT);

    public LoginPane() {

        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().add(loginTitle);

        GridPane gridLogin = new GridPane();
        gridLogin.setAlignment(Pos.CENTER);
        gridLogin.setPadding(new Insets(20, 20, 20, 20));
        gridLogin.setVgap(10);
        gridLogin.setHgap(10);
        gridLogin.add(usernameLbl, 0, 0);
        gridLogin.add(usernameFld, 1, 0);
        gridLogin.add(passwordLbl, 0, 1);
        gridLogin.add(passwordFld, 1, 1);

        HBox hBox2 = new HBox(20);
        hBox2.getChildren().addAll(logoutBtn, loginBtn);
        gridLogin.add(hBox2, 1, 3);

        this.setTop(hBox1);
        this.setCenter(gridLogin);
    }

    public TextField getUsernameFld() {
        return usernameFld;
    }

    public PasswordField getPasswordFld() {
        return passwordFld;
    }

}
