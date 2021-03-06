package djoleapp.business.storage;

import djoleapp.business.model.Administrator;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import java.util.List;

/**
 *
 * @author perica.simic
 */
public interface Storage {

    public List<Administrator> loadAdmin();

    public void writeAdmins(List<Administrator> list);

    public List<ResidentialCommunity> loadResidentialCommunities();

    public void writeResidentialCommunities(List<ResidentialCommunity> list);
    
    public List<Occupant> loadOccupants();

    public void writeOccupants(List<Occupant> list);
  

}
