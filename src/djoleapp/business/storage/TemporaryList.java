package djoleapp.business.storage;

import djoleapp.business.Factory;
import djoleapp.business.model.Administrator;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import java.util.List;

public class TemporaryList {

    List<Administrator> administrators;
    List<ResidentialCommunity> residentialCommunitys;
    List<Occupant> occupants;

    public TemporaryList() {
        administrators = Factory.getStorage().loadAdmin();
        residentialCommunitys = Factory.getStorage().loadResidentialCommunities();
        occupants = Factory.getStorage().loadOccupants();
    }

    public void saveTemporaryLists() {
        Factory.getStorage().writeAdmins(administrators);
        Factory.getStorage().writeResidentialCommunities(residentialCommunitys);
        Factory.getStorage().writeOccupants(occupants);
    }

    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }

    public List<ResidentialCommunity> getResidentialCommunitys() {
        return residentialCommunitys;
    }

    public void setResidentialCommunitys(List<ResidentialCommunity> residentialCommunitys) {
        this.residentialCommunitys = residentialCommunitys;
    }

    public List<Occupant> getOccupants() {
        return occupants;
    }

    public void setOccupants(List<Occupant> occupants) {
        this.occupants = occupants;
    }
    
}
