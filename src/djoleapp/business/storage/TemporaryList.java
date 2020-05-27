package djoleapp.business.storage;

import djoleapp.business.Factory;
import djoleapp.business.model.Administrator;
import djoleapp.business.model.BankAccount;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import java.util.List;

public class TemporaryList {

    List<Administrator> administrators;
    List<ResidentialCommunity> residentialCommunitys;
//    List<BankAccount> bankAccounts;
    List<Occupant> occupants;
    List<SeparateSection> separateSections;

    public TemporaryList() {
        administrators = Factory.getStorage().loadAdmin();
        residentialCommunitys = Factory.getStorage().loadResidentialCommunities();
        occupants = Factory.getStorage().loadOccupants();
        separateSections = Factory.getStorage().loadSeparateSections();
    }

    public void saveTemporaryLists() {
        Factory.getStorage().writeAdmins(administrators);
        Factory.getStorage().writeResidentialCommunities(residentialCommunitys);
        Factory.getStorage().writeOccupants(occupants);
        Factory.getStorage().writeSeparateSections(separateSections);
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

    public List<SeparateSection> getSeparateSections() {
        return separateSections;
    }

    public void setSeparateSections(List<SeparateSection> separateSections) {
        this.separateSections = separateSections;
    }
    
    
    
}
