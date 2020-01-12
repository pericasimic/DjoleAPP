/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djoleapp.business;

import djoleapp.business.facade.Facade;
import djoleapp.business.facade.FacadeSER;
import djoleapp.business.storage.SerStorage;
import djoleapp.business.storage.Storage;

/**
 *
 * @author perica.simic
 */
public class Factory {
    
    private static Facade facade = new FacadeSER();
    private static Storage storage = new SerStorage();

    public static Facade getFacade() {
        return facade;
    }

    public static Storage getStorage() {
        return storage;
    }
    
    
}
