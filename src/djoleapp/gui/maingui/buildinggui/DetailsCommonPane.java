package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.CommonSection;
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

public class DetailsCommonPane extends BorderPane {

    private final Label title = new Label();

    private TextField buildingFld = new TextField();
    private TextArea noteFld = new TextArea();
    private TextField nameFld = new TextField();
    private TextField pricePerMonth = new TextField();

    private final Label buildingLbl = new Label(Constants.BUILDING);
    private final Label noteLbl = new Label(Constants.NOTE);
    private final Label nameLbl = new Label(Constants.NAME_OF_SECTION);
    private final Label priceLbl = new Label(Constants.PRICE_PER_MONTH);

    private final Button exitBtn = new Button(Constants.BUTTON_BACK);

    private HBox hBox = new HBox();

    public DetailsCommonPane(CommonSection section) {

        title.getStyleClass().add(CssId.LOGIN_TITLE);
        title.setText(Constants.COMMON_SECTIONS + ": " + section.getName());
        this.setTop(title);

        GridPane gp = new GridPane();
        gp.getStyleClass().add(CssId.GRID_LOGIN);

        buildingFld.setText(Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getName());
        buildingFld.setEditable(false);
        nameFld.setText(section.getName());
        nameFld.setEditable(false);
        if (section.getNote().isEmpty() || section.getNote() != null) {
            noteFld.setText(section.getNote());
        }
        noteFld.setEditable(false);
        if (section.getPricePerMonth() != 0) {
            pricePerMonth.setText(String.valueOf(section.getPricePerMonth()));
        }
        pricePerMonth.setEditable(false);

        gp.add(buildingLbl, 0, 1);
        gp.add(buildingFld, 1, 1);
        gp.add(nameLbl, 0, 2);
        gp.add(nameFld, 1, 2);
        gp.add(noteLbl, 0, 3);
        gp.add(noteFld, 1, 3);
        gp.add(priceLbl, 0, 4);
        gp.add(pricePerMonth, 1, 4);

        exitBtn.setOnAction(Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent());
        exitBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent().showSelectBuildTableEvent();
            }

        });

        hBox.getStyleClass().add(CssId.HBOX_BOTTOM_MAIN);
        hBox.getChildren().add(exitBtn);

        this.getStyleClass().add(CssId.BORDER_PANE_DETAILS_SEP_PANE);
        this.setCenter(gp);
        this.setBottom(hBox);
    }
}
