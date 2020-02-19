package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;

public class TopHBoxBuildingPane extends HBox {

    private Label selectBuildingLbl = new Label(Constants.SELECT_BUILDINGS);
    private Label selectItemLbl = new Label(Constants.SELECT_ITEM);
    private Label showLbl = new Label();
    private ComboBox<ResidentialCommunity> buildingsBox = new ComboBox<>();
    private ComboBox<String> selectItemBox = new ComboBox<>();
    private Button showBtn = new Button(Constants.BUTTON_SHOW);

    public TopHBoxBuildingPane() {

        this.setSpacing(50);
        this.setStyle(Constants.FX_BORDER_COLOR_BLACK);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setAlignment(Pos.CENTER);

        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(selectBuildingLbl, buildingsBox);

        VBox vBox2 = new VBox();
        vBox2.setSpacing(10);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.getChildren().addAll(selectItemLbl, selectItemBox);

        VBox vBox3 = new VBox();
        vBox3.setSpacing(10);
        vBox3.setAlignment(Pos.CENTER);
        vBox3.getChildren().addAll(showLbl, showBtn);

        buildingsBox.setMaxWidth(USE_PREF_SIZE);
        buildingsBox.setItems(FXCollections.observableArrayList(Controller.getInstance().getTemporaryList().getResidentialCommunitys()));

        selectItemBox.setMaxWidth(USE_PREF_SIZE);
        selectItemBox.getItems().addAll(Constants.BANK_ACCOUNT, Constants.OCCUPANTS, Constants.MENU_ITEM_BUILDING_UNITS);

        showBtn.setMaxWidth(USE_PREF_SIZE);

        showBtn.setOnAction(Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent());
        showBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent().showSelectBuildTableEvent();
            }
        });

        this.getChildren().addAll(vBox1, vBox2, vBox3);

    }

    public ComboBox<ResidentialCommunity> getBuildingsBox() {
        return buildingsBox;
    }

    public ComboBox<String> getSelectItemBox() {
        return selectItemBox;
    }

}
