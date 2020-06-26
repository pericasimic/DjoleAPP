package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.Occupant;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class AddIndependentPane extends BorderPane {

    private Label title = new Label(Constants.TITLE_ADD_IND_SECTION + Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getName());

    private TextField nameFld = new TextField();
    private TextArea noteFld = new TextArea();
    private TextField pricePerMonth = new TextField();

    private ComboBox<Occupant> ownerBox = new ComboBox<>();

    private Label nameLbl = new Label(Constants.NAME_OF_SECTION);
    private Label priceLbl = new Label(Constants.PRICE_PER_MONTH);
    private Label noteLbl = new Label(Constants.NOTE);
    private Label renterLbl = new Label(Constants.RENTER);

    private Button confirmBtn = new Button(Constants.BUTTON_CONFIRM);
    private Button cancelBtn = new Button(Constants.BUTTON_CANCEL);

    public AddIndependentPane() {
        title.setFont(new Font(Constants.FONT_ARIAL, 20));
        this.setTop(title);

        GridPane gp = new GridPane();
        gp.setStyle(Constants.FX_BORDER_COLOR_BLACK);
        gp.setAlignment(Pos.CENTER);

        gp.setVgap(5);
        gp.setHgap(5);

        gp.add(nameLbl, 0, 0);
        gp.add(nameFld, 1, 0);
        gp.add(noteLbl, 0, 1);
        gp.add(noteFld, 1, 1);
        gp.add(priceLbl, 0, 2);
        gp.add(pricePerMonth, 1, 2);
        gp.add(renterLbl, 0, 3);
        gp.add(ownerBox, 1, 3);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(3);
        hBox.setPadding(new Insets(30, 30, 30, 30));

        confirmBtn.setOnAction(Controller.getInstance().getManagerEvent().getConfirmAddIndEvent());
        confirmBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getConfirmAddIndEvent();
            }

        });
        cancelBtn.setOnAction(Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent());
        cancelBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent();
            }

        });

        ownerBox.setMaxWidth(USE_PREF_SIZE);
        ownerBox.setItems(FXCollections.observableArrayList(Controller.getInstance().getTemporaryList().getOccupants()));

        hBox.getChildren().addAll(cancelBtn, confirmBtn);

        this.setPadding(new Insets(60, 60, 60, 60));
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

    public ComboBox<Occupant> getOwnerBox() {
        return ownerBox;
    }

    public void setOwnerBox(ComboBox<Occupant> ownerBox) {
        this.ownerBox = ownerBox;
    }
    

}
