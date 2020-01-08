/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djoleapp.controller.event.adminevent;

import djoleapp.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author perica.simic
 */
public class LoginEvent implements EventHandler<ActionEvent>{

    @Override
    public void handle(ActionEvent event) {
        loginEvent();
    }
    
    private void loginEvent(){
        
        String checkUsername = Controller.getInstance().getLoginPane().getUsernameFld().getText();
        Controller.getInstance().getLoginPane().getUsernameFld().setText(null);
        
        String checkPassword = Controller.getInstance().getLoginPane().getPasswordFld().getText();
        Controller.getInstance().getLoginPane().getUsernameFld().setText(null);
        
    }
    
}
