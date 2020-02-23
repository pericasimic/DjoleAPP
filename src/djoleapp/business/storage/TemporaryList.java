package djoleapp.business.storage;

import djoleapp.business.Factory;
import djoleapp.business.model.Administrator;
import djoleapp.business.model.BankAccount;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import java.util.List;

public class TemporaryList {

    List<Administrator> administrators;
    List<ResidentialCommunity> residentialCommunitys;
    List<BankAccount> bankAccounts;
    List<Occupant> occupants;

    public TemporaryList() {
        administrators = Factory.getStorage().loadAdmin();
        residentialCommunitys = Factory.getStorage().loadResidentialCommunities();
        bankAccounts = Factory.getStorage().loadBankAccounts();
        occupants = Factory.getStorage().loadOccupants();
    }

    public void saveTemporaryLists() {
        Factory.getStorage().writeAdmins(administrators);
        Factory.getStorage().writeResidentialCommunities(residentialCommunitys);
        Factory.getStorage().writeBankAccounts(bankAccounts);
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

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<Occupant> getOccupants() {
        return occupants;
    }

    public void setOccupants(List<Occupant> occupants) {
        this.occupants = occupants;
    }
    
}
