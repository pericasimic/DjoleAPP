package djoleapp.gui.admingui;

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

public class AddAdminPane extends BorderPane {

    private final Label titleAddAdmin = new Label(Constants.TITLE_ADD_ADMIN);
    private final Label addUsernameLbl = new Label(Constants.USERNAME_LBL);
    private final Label addPasswordLbl = new Label(Constants.PASSWORD_LBL);
    private final Label confirmPasswordLbl = new Label(Constants.ADD_ADMIN_LABEL_PASSWORD_CONFIRM);

    private final TextField addUsernameFld = new TextField();
    private final PasswordField addPasswordFld = new PasswordField();
    private final PasswordField confirmPasswordFld = new PasswordField();

    private final Button confirmBtn = new Button(Constants.BUTTON_CONFIRM);
    private final Button logoutBtn = new Button(Constants.BUTTON_LOGOUT);

    public AddAdminPane() {

        titleAddAdmin.getStyleClass().add(CssId.LOGIN_TITLE);
        
        HBox hBox = new HBox();
        hBox.getStyleClass().add(CssId.HBOX);
        hBox.getChildren().add(titleAddAdmin);

        GridPane gridPane = new GridPane();
        gridPane.getStyleClass().add(CssId.GRID_LOGIN);
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
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getAddAdminEvent().addAdminEvent();
            }
        });

        logoutBtn.setOnAction(Controller.getInstance().getManagerEvent().getLogoutEvent());
        logoutBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getLogoutEvent().logoutEvent();
            }
        });

        this.getStyleClass().add(CssId.BORDER_PANE_LOGIN);
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
