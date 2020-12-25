package djoleapp.gui.maingui.buildinggui;

import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.constant.CssId;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AddCommonPane extends BorderPane {

    private final Label title = new Label(Constants.TITLE_ADD_COMMON_SECTION + Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getName());

    private TextField nameFld = new TextField();
    private TextArea noteFld = new TextArea();
    private TextField pricePerMonth = new TextField();

    private final Label nameLbl = new Label(Constants.NAME_OF_SECTION);
    private final Label priceLbl = new Label(Constants.PRICE_PER_MONTH);
    private final Label noteLbl = new Label(Constants.NOTE);

    private final Button confirmBtn = new Button(Constants.BUTTON_CONFIRM);
    private final Button cancelBtn = new Button(Constants.BUTTON_CANCEL);

    public AddCommonPane() {
        title.getStyleClass().add(CssId.LABEL_TITTLE);
        this.setTop(title);

        GridPane gp = new GridPane();
        gp.getStyleClass().add(CssId.GRID_LOGIN);

        gp.add(nameLbl, 0, 0);
        gp.add(nameFld, 1, 0);
        gp.add(noteLbl, 0, 1);
        gp.add(noteFld, 1, 1);
        gp.add(priceLbl, 0, 2);
        gp.add(pricePerMonth, 1, 2);

        HBox hBox = new HBox();
        hBox.getStyleClass().add(CssId.HBOX_BOTTOM_MAIN);

        confirmBtn.setOnAction(Controller.getInstance().getManagerEvent().getConfirmAddCommonEvent());
        confirmBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getConfirmAddCommonEvent().confirmAddCommonEvent();
            }

        });
        cancelBtn.setOnAction(Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent());
        cancelBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent().showSelectBuildTableEvent();
            }

        });

        hBox.getChildren().addAll(cancelBtn, confirmBtn);

        this.getStyleClass().add(CssId.BORDER_PANE_DETAILS_SEP_PANE);
        this.setCenter(gp);
        this.setBottom(hBox);

    }

    public TextField getNameFld() {
        return nameFld;
    }

    public void setNameFld(TextField nameFld) {
        this.nameFld = nameFld;
    }

    public TextArea getNoteFld() {
        return noteFld;
    }

    public void setNoteFld(TextArea noteFld) {
        this.noteFld = noteFld;
    }

    public TextField getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(TextField pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

}
