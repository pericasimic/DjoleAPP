/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djoleapp.business.facade;

import djoleapp.business.Factory;
import djoleapp.business.model.Administrator;
import djoleapp.controller.Controller;
import java.util.List;

/**
 *
 * @author perica.simic
 */
public class FacadeSER implements Facade{

    @Override
    public boolean loginAdminCheck(String username, String password) {
        List<Administrator> list = Factory.getStorage().loadAdmin();
        for(Administrator a: list){
            if(username.equals(a.getUsername()) && password.equals(a.getPassword())){
                return true;
            }
        }
        return false;
    }
    
}
