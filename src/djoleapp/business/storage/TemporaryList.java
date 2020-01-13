package djoleapp.business.storage;

import djoleapp.business.Factory;
import djoleapp.business.model.Administrator;
import java.util.List;

public class TemporaryList {
    
    List<Administrator> administrators;
    
    public TemporaryList(){
        administrators = Factory.getStorage().loadAdmin();
    }

    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }
    
    
}
