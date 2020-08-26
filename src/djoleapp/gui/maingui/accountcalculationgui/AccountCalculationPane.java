package djoleapp.gui.maingui.accountcalculationgui;

import djoleapp.business.model.AccountCalculation;
import djoleapp.business.model.Occupant;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.finance.TableCalculations;
import djoleapp.gui.maingui.occupantgui.TableOccupant;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class AccountCalculationPane extends VBox {
    
    private Label titleLbl = new Label();
    
    private TextField searchOccupantFld = new TextField();
    
    private TableCalculations tableCalculations;
    
    private Button addOccupantBtn = new Button(Constants.BUTTON_ADD);
    private Button removeOccupantBtn = new Button(Constants.BUTTON_REMOVE);
    private Button serchOccupantBtn = new Button(Constants.BUTTON_SEARCH);
    
    public AccountCalculationPane(Occupant o) {
        titleLbl.setFont(new Font(Constants.FONT_ARIAL, 20));
        titleLbl.setText(Constants.ACCOUNTS + " korisnika " + o.getFirstNameOccupant() + " " + o.getLastNameOccupant());
        setSpacing(5);
        setPadding(new Insets(10, 10, 10, 10));
        
        tableCalculations = new TableCalculations(o.getListAccountCalc());
        
        tableCalculations.setRowFactory(tv -> {
            TableRow<AccountCalculation> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    AccountCalculation rowData = row.getItem();
//                    Controller.getInstance().getManagerEvent().getSelectOccupantEvent().selectOccupantEvent(rowData);
                }
            });
            return row;
        });
        
        Controller.getInstance().setTableCalculations(tableCalculations);
        
        getChildren().addAll(titleLbl, getSearch(), tableCalculations, getForm());
        
    }
    
    private HBox getSearch() {
        
        HBox hSearch = new HBox();
        hSearch.setSpacing(3);
        hSearch.setPadding(new Insets(10, 10, 10, 10));
        hSearch.setAlignment(Pos.CENTER);
        
        searchOccupantFld.setMaxWidth(USE_PREF_SIZE);
        
        serchOccupantBtn.setOnAction(Controller.getInstance().getManagerEvent().getSearchUserEvent());
        serchOccupantBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getSearchUserEvent().searchUserEvent();
            }
        });
        
        hSearch.getChildren().addAll(searchOccupantFld, serchOccupantBtn);
        return hSearch;
        
    }
    
    private HBox getForm() {
        
        HBox hbox = new HBox();
        hbox.setSpacing(3);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setAlignment(Pos.CENTER);
        
        addOccupantBtn.setOnAction(Controller.getInstance().getManagerEvent().getAddOccupantEvent());
        addOccupantBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getAddOccupantEvent().addOccupantEvent();
            }
            
        });
        
        removeOccupantBtn.setOnAction(Controller.getInstance().getManagerEvent().getRemoveUserEvent());
        removeOccupantBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getRemoveUserEvent();
            }
            
        });
        
        hbox.getChildren().addAll(removeOccupantBtn, addOccupantBtn);
        return hbox;
    }
    
    
    public void reloadTable(List<AccountCalculation> list) {
        tableCalculations.setItems(FXCollections.observableArrayList(list));
    }

    public TableCalculations getTableCalculations() {
        return tableCalculations;
    }

    public void setTableCalculations(TableCalculations tableCalculations) {
        this.tableCalculations = tableCalculations;
    }
    
}
