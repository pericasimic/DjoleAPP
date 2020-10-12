package djoleapp.gui;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.constant.CssId;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class LoginPane extends BorderPane {

    private final Label loginTitle = new Label(Constants.TITLE_LOGIN);
    private final Label usernameLbl = new Label(Constants.USERNAME_LBL);
    private final Label passwordLbl = new Label(Constants.PASSWORD_LBL);
    private final TextField usernameFld = new TextField();
    private final PasswordField passwordFld = new PasswordField();
    private final Button loginBtn = new Button(Constants.BUTTON_LOGIN);
    private final Button logoutBtn = new Button(Constants.BUTTON_LOGOUT);

    public LoginPane() {

        loginTitle.getStyleClass().add(CssId.LOGIN_TITLE);

        HBox hBox1 = new HBox();
        hBox1.getStyleClass().add(CssId.HBOX);
        hBox1.getChildren().add(loginTitle);

        GridPane gridLogin = new GridPane();
        gridLogin.getStyleClass().add(CssId.GRID_LOGIN);
        gridLogin.add(usernameLbl, 0, 0);
        gridLogin.add(usernameFld, 1, 0);
        gridLogin.add(passwordLbl, 0, 1);
        gridLogin.add(passwordFld, 1, 1);

        HBox hBox2 = new HBox(20);
        hBox2.getChildren().addAll(logoutBtn, loginBtn);
        gridLogin.add(hBox2, 1, 3);

        this.getStyleClass().add(CssId.BORDER_PANE_LOGIN);
        this.setTop(hBox1);
        this.setCenter(gridLogin);

        loginBtn.setOnAction(Controller.getInstance().getManagerEvent().getLoginEvent());
        loginBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getLoginEvent().loginEvent();
            }
        });

        logoutBtn.setOnAction(Controller.getInstance().getManagerEvent().getLogoutEvent());
        logoutBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getLogoutEvent().logoutEvent();
            }
        });
    }

    public TextField getUsernameFld() {
        return usernameFld;
    }

    public PasswordField getPasswordFld() {
        return passwordFld;
    }

}
