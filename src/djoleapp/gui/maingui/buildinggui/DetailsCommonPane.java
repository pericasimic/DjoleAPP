package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.CommonSection;
import djoleapp.business.model.IndependentSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class DetailsCommonPane extends BorderPane {
    private Label title = new Label();

    private TextField buildingFld = new TextField();
    private TextArea noteFld = new TextArea();
    private TextField nameFld = new TextField();
    private TextField pricePerMonth = new TextField();

    private Label buildingLbl = new Label(Constants.BUILDING);
    private Label noteLbl = new Label(Constants.NOTE);
    private Label nameLbl = new Label(Constants.NAME_OF_SECTION);
    private Label priceLbl = new Label(Constants.PRICE_PER_MONTH);
    
    private Button exitBtn = new Button(Constants.BUTTON_BACK);

    private HBox hBox = new HBox();

    public DetailsCommonPane(CommonSection section) {

        title.setFont(new Font(Constants.FONT_ARIAL, 20));
        title.setText(Constants.COMMON_SECTIONS + ": " + section.getName());
        this.setTop(title);

        GridPane gp = new GridPane();
        gp.setStyle(Constants.FX_BORDER_COLOR_BLACK);
        gp.setAlignment(Pos.CENTER);

        gp.setVgap(5);
        gp.setHgap(5);

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

        exitBtn.setOnAction(Controller.getInstance().getManagerEvent().getDetailsCommonSectionEvent());
        exitBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getDetailsCommonSectionEvent();
            }

        });

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(3);
        hBox.setPadding(new Insets(30, 30, 30, 30));

        
        hBox.getChildren().add(exitBtn);

        this.setPadding(new Insets(60, 60, 60, 60));
        this.setCenter(gp);
        this.setBottom(hBox);
    }
}