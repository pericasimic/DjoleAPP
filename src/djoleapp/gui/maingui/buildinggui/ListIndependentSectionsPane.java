package djoleapp.gui.maingui.buildinggui;

import djoleapp.business.model.IndependentSection;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.constant.CssId;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class ListIndependentSectionsPane extends VBox {

    private TableIndependent tableIndependent;
    private Button addBtn = new Button(Constants.BUTTON_ADD);
    private Button deleteBtn = new Button(Constants.BUTTON_REMOVE);
    private Button backBtn = new Button(Constants.BUTTON_BACK);
    private Label title = new Label(Constants.INDEPENDENT_SECTIONS);

    public ListIndependentSectionsPane(List<IndependentSection> list) {
        
        title.getStyleClass().add(CssId.LABEL_TITTLE);
        commonMade();
        tableIndependent = new TableIndependent(list);

        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        hBox1.setPadding(new Insets(10, 10, 10, 10));
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(backBtn);

        backBtn.setOnAction(Controller.getInstance().getManagerEvent().getBackAddAccountOccupantEvent());
        backBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getBackAddAccountOccupantEvent().backAddAccountOccupantEvent();
            }

        });

        this.getChildren().addAll(title, tableIndependent, hBox1);
    }

    public ListIndependentSectionsPane(List<IndependentSection> list, HBox hBox) {

        commonMade();

        tableIndependent = new TableIndependent(list);

        HBox hBox1 = new HBox();
        hBox1.getStyleClass().add(CssId.HBOX_BOTTOM_MAIN);
        hBox1.getChildren().addAll(deleteBtn, addBtn);

        tableIndependent.setRowFactory(tv -> {
            TableRow<IndependentSection> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Controller.getInstance().getManagerEvent().getDetailsIndependentEvent().detailsIndependentEvent(row.getItem());
                }
            });
            return row;

        });
        
        deleteBtn.setOnAction(Controller.getInstance().getManagerEvent().getRemoveIndSectionEvent());
        deleteBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getRemoveIndSectionEvent().removeIndSectionEvent();
            }

        });

        addBtn.setOnAction(Controller.getInstance().getManagerEvent().getAddIndependentEvent());
        addBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getAddIndependentEvent();
            }

        });

        this.getChildren().addAll(hBox, tableIndependent, hBox1);

    }

    private void commonMade() {
        this.getStyleClass().add(CssId.MAIN_PADDING);
        Controller.getInstance().setTableIndependent(tableIndependent);

    }

    public void reload(List<IndependentSection> list) {
        tableIndependent.setItems(FXCollections.observableArrayList(list));

    }

    public TableIndependent getTableIndependent() {
        return tableIndependent;
    }

}
