package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.constant.CssId;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;

public class TopHBoxBuildingPane extends HBox {

    private final Label selectBuildingLbl = new Label(Constants.SELECT_BUILDINGS);
    private final Label selectItemLbl = new Label(Constants.SELECT_ITEM);
    private final Label showLbl = new Label();
    private ComboBox<ResidentialCommunity> buildingsBox = new ComboBox<>();
    private final ComboBox<String> selectItemBox = new ComboBox<>();
    private final Button showBtn = new Button(Constants.BUTTON_SHOW);

    public TopHBoxBuildingPane() {

        this.getStyleClass().add(CssId.HBOX_TOP_BOX);

        VBox vBox1 = new VBox();
        vBox1.getStyleClass().add(CssId.VBOX_TOP_BOX);
        vBox1.getChildren().addAll(selectBuildingLbl, buildingsBox);

        VBox vBox2 = new VBox();
        vBox2.getStyleClass().add(CssId.VBOX_TOP_BOX);
        vBox2.getChildren().addAll(selectItemLbl, selectItemBox);

        VBox vBox3 = new VBox();
        vBox3.getStyleClass().add(CssId.VBOX_TOP_BOX);
        vBox3.getChildren().addAll(showLbl, showBtn);

        buildingsBox.setMaxWidth(USE_PREF_SIZE);
        buildingsBox.setItems(FXCollections.observableArrayList(Controller.getInstance().getTemporaryList().getResidentialCommunitys()));

        selectItemBox.setMaxWidth(USE_PREF_SIZE);
        selectItemBox.getItems().addAll(Constants.BANK_ACCOUNT, Constants.OCCUPANTS, Constants.SEPARATE_SECTIONS, Constants.INDEPENDENT_SECTIONS, Constants.COMMON_SECTIONS);

        showBtn.setMaxWidth(USE_PREF_SIZE);

        showBtn.setOnAction(Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent());
        showBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent().showSelectBuildTableEvent();
            }
        });

        this.getChildren().addAll(vBox1, vBox2, vBox3);

    }

    public void reloadBuildingBox(List<ResidentialCommunity> list) {
        buildingsBox.setItems(FXCollections.observableArrayList(list));
    }

    public ComboBox<ResidentialCommunity> getBuildingsBox() {
        return buildingsBox;
    }

    public void setBuildingsBox(ComboBox<ResidentialCommunity> buildingsBox) {
        this.buildingsBox = buildingsBox;
    }

    public ComboBox<String> getSelectItemBox() {
        return selectItemBox;
    }

}
