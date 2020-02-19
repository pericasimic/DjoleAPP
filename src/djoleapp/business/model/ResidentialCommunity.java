package djoleapp.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResidentialCommunity implements Serializable {

    private int id;
    private String name;
    private String identificationNumber;
    private String taxIdentificationNumber;
    private String mail;
    private List<Occupant> listOccupants = new ArrayList<>();
    private List<BankAccount> bankAccounts = new ArrayList<>();
    private List<SeparateSection> listSeparationSection = new ArrayList<>();
    private boolean isExist = true;

    public ResidentialCommunity(int id) {
        this.id = id;
    }

    public ResidentialCommunity(int id, String name, String identificationNumber, String taxIdentificationNumber, String mail) {
        this.id = id;
        this.name = name;
        this.identificationNumber = identificationNumber;
        this.taxIdentificationNumber = taxIdentificationNumber;
        this.mail = mail;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Occupant> getListOccupants() {
        return listOccupants;
    }

    public void setListOccupants(List<Occupant> listOccupants) {
        this.listOccupants = listOccupants;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<SeparateSection> getListSeparationSection() {
        return listSeparationSection;
    }

    public void setListSeparationSection(List<SeparateSection> listSeparationSection) {
        this.listSeparationSection = listSeparationSection;
    }

    public boolean isIsExist() {
        return isExist;
    }

    public void setIsExist(boolean isExist) {
        this.isExist = isExist;
    }

    @Override
    public String toString() {
        return id + ". " + name;
    }

}
