package djoleapp.business.facade;

import djoleapp.business.model.BankAccount;
import djoleapp.business.model.CommonSection;
import djoleapp.business.model.Flat;
import djoleapp.business.model.IndependentSection;
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

    public boolean checkAddBuildingFieldsEmpty(String name, String idNum, String taxNum, String mail);

    public boolean checkAddBuildingFieldExist(String name, String idNum, String taxNum, String mail);

    public boolean chackExistOccupantBuilding(ResidentialCommunity r, Occupant o);
    
    public void writeId(long id);
    
    public long readId();

    public List<Occupant> getListfreeOccupants();

    public double supportSum(double price, double area);

    public double pricePerArea(SeparateSection section);

    public String kindOfSection(SeparateSection section);

    public List<ResidentialCommunity> searchBuidingList(String word);

    public List<Occupant> searchUserList(String word);

    public boolean removeBuilding(ResidentialCommunity rc);

    public void removeBuildingOccupant(ResidentialCommunity rc, Occupant o);

    public boolean removeBankAccount(BankAccount ba, ResidentialCommunity rc);

    public void removeSeparateSection(SeparateSection ss, ResidentialCommunity rc);

    public boolean checkBankAccount(String name, String number);

    public boolean addSeparateSection(boolean isAdd, ResidentialCommunity rc, String section, String number, String area, String note, Occupant owner);

    public void addIndSection(String name, String note, Occupant owner, String price);

    public void removeIndSection(IndependentSection independentSection);

    public void removeCommonSection(CommonSection commonSection);

    public void addCommonSection(String name, String note, String price);

    public List<Flat> getFlats(ResidentialCommunity r);

    public void addOccupantBuilding(ResidentialCommunity rc, Occupant o, SeparateSection ss);

    public void removeOccupant(Occupant o);
    
    public boolean addOccupant(long id, String firstName, String lastName, String idNum, String phone, String mail, String note);
    
    
}
