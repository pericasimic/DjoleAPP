package djoleapp.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Occupant implements Serializable {

    private long id;
    private String firstNameOccupant;
    private String lastNameOccupant;
    private String identificationNumber;
    private String phoneNumber;
    private String mail;
    private String note;
    private double sum = 0;
    private List<IndependentSection> independents = new ArrayList<>();
    private List<ResidentialCommunity> residentials = new ArrayList<>();
    private List<BankAccount> bankAccounts = new ArrayList<>();
    private List<SeparateSection> listSeparateSections = new ArrayList<>();
    private List<AccountCalculation> listAccountCalc = new ArrayList<>();
    private List<BankingStatement> listStatements = new ArrayList<>();
    private boolean isAdd = false;
    private boolean isExist = true;

    public Occupant(long id) {
        this.id = id;
    }

    public Occupant(long id, String firstNameOccupant, String lastNameOccupant, String identificationNumber, String phoneNumber, String mail) {
        this.id = id;
        this.firstNameOccupant = firstNameOccupant;
        this.lastNameOccupant = lastNameOccupant;
        this.identificationNumber = identificationNumber;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public String getFirstNameOccupant() {
        return firstNameOccupant;
    }

    public void setFirstNameOccupant(String firstNameOccupant) {
        this.firstNameOccupant = firstNameOccupant;
    }

    public String getLastNameOccupant() {
        return lastNameOccupant;
    }

    public void setLastNameOccupant(String lastNameOccupant) {
        this.lastNameOccupant = lastNameOccupant;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isIsExist() {
        return isExist;
    }

    public void setIsExist(boolean isExist) {
        this.isExist = isExist;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public List<AccountCalculation> getListAccountCalc() {
        return listAccountCalc;
    }

    public void setListAccountCalc(List<AccountCalculation> listAccountCalc) {
        this.listAccountCalc = listAccountCalc;
    }

    public List<BankingStatement> getListStatements() {
        return listStatements;
    }

    public void setListStatements(List<BankingStatement> listStatements) {
        this.listStatements = listStatements;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public List<IndependentSection> getIndependents() {
        return independents;
    }

    public void setIndependents(List<IndependentSection> independents) {
        this.independents = independents;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public List<SeparateSection> getListSeparateSections() {
        return listSeparateSections;
    }

    public void setListSeparateSections(List<SeparateSection> listSeparateSections) {
        this.listSeparateSections = listSeparateSections;
    }

    public List<ResidentialCommunity> getResidentials() {
        return residentials;
    }

    public void setResidentials(List<ResidentialCommunity> residentials) {
        this.residentials = residentials;
    }

    public boolean isIsAdd() {
        return isAdd;
    }

    public void setIsAdd(boolean isAdd) {
        this.isAdd = isAdd;
    }
    
    

    @Override
    public String toString() {
        return id + ". " + firstNameOccupant + " " + lastNameOccupant;
    }
}
