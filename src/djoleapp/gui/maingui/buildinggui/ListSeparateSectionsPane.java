package djoleapp.gui.maingui.buildinggui;


import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableRow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ListSeparateSectionsPane extends VBox {

    private TableSection tableSection;
    private Button addBtn = new Button(Constants.BUTTON_ADD);
    private Button deleteBtn = new Button(Constants.BUTTON_REMOVE);

    public ListSeparateSectionsPane(List<SeparateSection> list, HBox hBox) {

        this.setPadding(new Insets(10, 10, 10, 10));

        tableSection = new TableSection(list);
        Controller.getInstance().setTableSection(tableSection);

        HBox hBox1 = new HBox();
        hBox1.setSpacing(10);
        hBox1.setPadding(new Insets(10, 10, 10, 10));
        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(deleteBtn, addBtn);

        tableSection.setRowFactory(tv -> {
            TableRow<SeparateSection> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Controller.getInstance().getManagerEvent().getDetailsSeparateEvent().detailsSeparateEvent(row.getItem());
                }
            });
            return row;

        });

        deleteBtn.setOnAction(Controller.getInstance().getManagerEvent().getAddOccupantBuildingEvent());
        deleteBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getAddOccupantBuildingEvent().addOccupantBuildingEvent();
            }

        });

        addBtn.setOnAction(Controller.getInstance().getManagerEvent().getAddSectionEvent());
        addBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getAddSectionEvent().addSectionEvent();
            }

        });

        this.getChildren().addAll(hBox, tableSection, hBox1);

    }

    public void reload(List<SeparateSection> list) {
        tableSection.setItems(FXCollections.observableArrayList(list));

    }

}
