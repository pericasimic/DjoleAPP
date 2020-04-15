package djoleapp.business.facade;

import djoleapp.business.model.Administrator;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.business.model.SeparateSection;
import java.util.List;

/**
 *
 * @author perica.simic
 */
public interface Facade {
    
    public boolean loginAdminCheck(final String username, final String password);
    public boolean chackExistOccupantBuilding(ResidentialCommunity r, Occupant o);
    public List<Occupant> getListfreeOccupants();
    public double supportSum(double price, double area);
    public double pricePerArea(SeparateSection section);
    
}
