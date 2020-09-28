package djoleapp.controller.event.financeevent;

import djoleapp.business.model.AccountCalculation;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.gui.maingui.MainPane;
import djoleapp.gui.maingui.finance.CalculationPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class AccountCalculationDetailsEvent implements EventHandler<ActionEvent>{
    
    public void showAccountCalculation(AccountCalculation accountCalculation){
        CalculationPane cp = new CalculationPane(accountCalculation);
        Controller.getInstance().setCalculationPane(cp);
        MainPane mp = new MainPane(cp);
        Scene scena = new Scene(mp, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        Controller.getInstance().getPrimaryStage().setScene(scena);
    }

    @Override
    public void handle(ActionEvent event) {
        showAccountCalculation(Controller.getInstance().getTemporaryAccountCalculation());
    }
    
}
