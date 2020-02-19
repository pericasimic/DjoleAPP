package djoleapp.business.facade;

import djoleapp.business.model.Administrator;

/**
 *
 * @author perica.simic
 */
public interface Facade {
    
    public boolean loginAdminCheck(final String username, final String password);
    
}
