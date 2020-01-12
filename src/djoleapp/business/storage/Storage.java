package djoleapp.business.storage;

import djoleapp.business.model.Administrator;
import java.util.List;

/**
 *
 * @author perica.simic
 */
public interface Storage {
    
    public List<Administrator> loadAdmin();
    public void writeAdmin(List<Administrator> list);
    
}
