package djoleapp.business.facade;

import djoleapp.business.model.AccountCalculation;
import djoleapp.business.model.BankAccount;
import djoleapp.business.model.CommonSection;
import djoleapp.business.model.Flat;
import djoleapp.business.model.IndependentSection;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.PaymentItems;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.business.model.SeparateSection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author perica.simic
 */
public interface Facade {

    public boolean loginAdminCheck(final String username, final String password);

    public boolean checkAddAdmin(String username, String password, String conPass);

    /*AddBuildingEvent*/
    public boolean checkAddBuildingFieldsEmpty(String name, String number, String city, String idNum, String taxNum, String mail);

    /*AddBuildingEvent*/
    public boolean checkAddBuildingFieldExist(String name, String number, String city, String idNum, String taxNum, String mail);

    /*AddBuildingEvent*/
    public boolean validateEmail(String emailStr);

    /*AddBuildingEvent*/
    public boolean validTaxNumber(String taxNumber);

    /*AddBuildingEvent*/
    public boolean validIDNumber(String idNumber);

    public void createNewCalculations();

    public void writeId(long id);

    public long readId();

    /*OccupantDetailsBuildingPane*/
    public List<Occupant> getListfreeOccupants();

    /*DetailsSeparatePane*/
    public double supportSum(double price, double area);

    public String kindOfSection(SeparateSection section);

    /*SearchBuildingEvent*/
    public List<ResidentialCommunity> searchBuidingList(String word);

    public List<Occupant> searchUserList(String word);

    /*RemoveBuildingEvent*/
    public boolean removeBuilding(ResidentialCommunity rc);

    /*RemoveBuildingOccupantEvent*/
    public void removeBuildingOccupant(ResidentialCommunity rc, Occupant o);

    /*RemoveBankAccountEvent*/
    public boolean removeBankAccount(BankAccount ba, ResidentialCommunity rc);

    /*RemoveSeparateSectionEvent*/
    public void removeSeparateSection(SeparateSection ss, ResidentialCommunity rc);

    /*AddBankAccountBuildEvent*/
    public boolean checkBankAccount(String name, String number);

    /*ConfirmEditSeparateEvent*/
    /*ConfirmAddSeparateEvent*/
    public boolean addSeparateSection(boolean isAdd, ResidentialCommunity rc, String section, String number, String area, String note, Occupant owner);

    /*ConfirmAddIndEvent*/
    public void addIndSection(String name, String note, Occupant owner, String price, ResidentialCommunity residentialCommunity);
    
    /*ConfirmEditIndependentEvent*/
    public void editIndSection(String name, String note, Occupant owner, String price, ResidentialCommunity residentialCommunity);

    /*RemoveIndSectionEvent*/
    public void removeIndSection(IndependentSection independentSection);

    /*RemoveCommonEvent*/
    public void removeCommonSection(CommonSection commonSection);

    /*ConfirmAddCommonEvent*/
    public void addCommonSection(String name, String note, String price);

    /*OccupantDetailsBuildingPane*/
    public List<Flat> getFlats(ResidentialCommunity r);

    /*AddOccupantBuildingEvent*/
    public void addOccupantBuilding(ResidentialCommunity rc, Occupant o, SeparateSection ss);

    public void removeOccupant(Occupant o);

    public boolean addOccupant(long id, String firstName, String lastName, String idNum, String phone, String mail, String note);

    public boolean editOccupant(String firstName, String lastName, String idNum, String phone, String mail, String note);

    public List<Occupant> getListOccupantsPerFlat(Flat flat);

    public List<SeparateSection> getSeparateSectionPerOccupant(Occupant o);

    public List<IndependentSection> getIndSectionPerOccupant(Occupant o);

    public boolean createBankAccountOccupant(String name, String number);

    public double pricePerArea(SeparateSection section);

    public List<PaymentItems> getListPayment(ResidentialCommunity residentialCommunity, Occupant o);

    public String returnMonth(int num);

    public String numberCalculation(ResidentialCommunity residentialCommunity, Occupant o, Date date);

    public String getDateFormat(Date date);

    public void changeCalculationSum(AccountCalculation ac, double sum);

}
