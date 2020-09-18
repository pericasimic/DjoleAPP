package djoleapp.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResidentialCommunity implements Serializable {

    private String name;
    private String number;
    private String city;
    private String identificationNumber;
    private String taxIdentificationNumber;
    private String mail;
    private List<Occupant> listOccupants = new ArrayList<>();
    private List<BankAccount> bankAccounts = new ArrayList<>();
    private List<SeparateSection> listSeparationSection = new ArrayList<>();
    private List<IndependentSection> listIndependentSections = new ArrayList<>();
    private List<CommonSection> listCommonSections = new ArrayList<>();

 
    public ResidentialCommunity(String name, String number, String city, String identificationNumber, String taxIdentificationNumber, String mail) {
        
        this.name = name;
        this.number = number;
        this.city = city;
        this.identificationNumber = identificationNumber;
        this.taxIdentificationNumber = taxIdentificationNumber;
        this.mail = mail;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public void setListIndependentSections(List<IndependentSection> listIndependentSections) {
        this.listIndependentSections = listIndependentSections;
    }

    public List<IndependentSection> getListIndependentSections() {
        return listIndependentSections;
    }

    public void setListCommonSections(List<CommonSection> listCommonSections) {
        this.listCommonSections = listCommonSections;
    }

    public List<CommonSection> getListCommonSections() {
        return listCommonSections;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    

    @Override
    public String toString() {
        return name + " " + number;
    }

}
