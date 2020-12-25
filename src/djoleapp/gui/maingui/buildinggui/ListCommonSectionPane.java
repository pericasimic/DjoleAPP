package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.CommonSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.constant.CssId;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.TableRow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ListCommonSectionPane extends VBox {

    private TableCommon tableCommon;
    private Button addBtn = new Button(Constants.BUTTON_ADD);
    private Button deleteBtn = new Button(Constants.BUTTON_REMOVE);

    public ListCommonSectionPane(List<CommonSection> list, HBox hBox) {

        this.getStyleClass().add(CssId.MAIN_PADDING);

        tableCommon = new TableCommon(list);
        Controller.getInstance().setTableCommon(tableCommon);

        HBox hBox1 = new HBox();
        hBox1.getStyleClass().add(CssId.HBOX_BOTTOM_MAIN);
        hBox1.getChildren().addAll(deleteBtn, addBtn);

        tableCommon.setRowFactory(tv -> {
            TableRow<CommonSection> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Controller.getInstance().getManagerEvent().getDetailsCommonSectionEvent().detailsCommonEvent(row.getItem());
                }
            });
            return row;

        });

        deleteBtn.setOnAction(Controller.getInstance().getManagerEvent().getRemoveCommonEvent());
        deleteBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getRemoveCommonEvent().removeCommonEvent();
            }

        });

        addBtn.setOnAction(Controller.getInstance().getManagerEvent().getAddCommonEvent());
        addBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getAddCommonEvent().addCommonEvent();
            }

        });

        this.getChildren().addAll(hBox, tableCommon, hBox1);

    }

    public void reload(List<CommonSection> list) {
        tableCommon.setItems(FXCollections.observableArrayList(list));

    }

    public TableCommon getTableCommon() {
        return tableCommon;
    }

    
    
}
