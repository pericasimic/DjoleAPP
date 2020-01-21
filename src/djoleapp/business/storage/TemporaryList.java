package djoleapp.business.storage;

import djoleapp.business.Factory;
import djoleapp.business.model.Administrator;
import djoleapp.business.model.ResidentialCommunity;
import java.util.List;

public class TemporaryList {

    List<Administrator> administrators;
    List<ResidentialCommunity> residentialCommunitys;

    public TemporaryList() {
        administrators = Factory.getStorage().loadAdmin();
        residentialCommunitys = Factory.getStorage().loadResidentialCommunities();
    }

    public void saveTemporaryLists() {
        Factory.getStorage().writeAdmin(administrators);
        Factory.getStorage().writeResidentialCommunities(residentialCommunitys);
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

}
