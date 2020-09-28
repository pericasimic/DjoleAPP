package djoleapp.gui.maingui.finance;

import djoleapp.business.model.AccountCalculation;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EditCalculationPane extends BorderPane {

    private Label titleLbl = new Label();
    private Label sumLbl = new Label(Constants.SUM_CALCULATION);
    private Label noteLbl = new Label(Constants.NOTE);
    
    private TextField sumFld = new TextField();
    private TextArea noteText = new TextArea();
    
    private Button cancelBtn = new Button(Constants.BUTTON_CANCEL);
    private Button editBtn = new Button(Constants.BUTTON_EDIT);
    
    
    public EditCalculationPane(AccountCalculation ac) {
        
        titleLbl.setText("Izmena računa broj " + ac.getCalculationNumber());
        sumFld.setText(String.valueOf(ac.getSum()));
        
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(sumLbl, sumFld, noteLbl, noteText);
        
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20));
        
        hBox.getChildren().addAll(cancelBtn, editBtn);
        
     
        cancelBtn.setOnAction(Controller.getInstance().getManagerEvent().getBackAddAccountOccupantEvent());
        cancelBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getBackAddAccountOccupantEvent().backAddAccountOccupantEvent();
            }
        });
        
        editBtn.setOnAction(Controller.getInstance().getManagerEvent().getChangeCalculationEvent());
        editBtn.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                Controller.getInstance().getManagerEvent().getChangeCalculationEvent().changeCalculationEvent();
            }
        });
        
        this.setTop(titleLbl);
        this.setCenter(vBox);
        this.setBottom(hBox);
    }

    public TextField getSumFld() {
        return sumFld;
    }

    public void setSumFld(TextField sumFld) {
        this.sumFld = sumFld;
    }

    public TextArea getNoteText() {
        return noteText;
    }

    public void setNoteText(TextArea noteText) {
        this.noteText = noteText;
    }
    

}
