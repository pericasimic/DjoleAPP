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
    
    private static final Facade facade = new FacadeSER();
    private static final Storage storage = new SerStorage();

    public static Facade getFacade() {
        return facade;
    }

    public static Storage getStorage() {
        return storage;
    }
    
    
}
