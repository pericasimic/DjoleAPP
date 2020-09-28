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
    private double sum;
    private Flat home;
    private List<SeparateSection> sections = new ArrayList<>();
    private List<Debit> debits = new ArrayList<>();
    private List<BankAccount> bankAccounts = new ArrayList<>();
    private List<AccountCalculation> listAccountCalc = new ArrayList<>();
    private List<BankingStatement> listStatements = new ArrayList<>();
    private boolean isAdd = false;

    public Occupant() {
    }

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

    public void setSections(List<SeparateSection> sections) {
        this.sections = sections;
    }

    public List<SeparateSection> getSections() {
        return sections;
    }

    public List<Debit> getDebits() {
        return debits;
    }

    public void setDebits(List<Debit> debits) {
        this.debits = debits;
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

    public double getSum() {
        double sumAll = 0;
        for (Debit d : debits) {
            sumAll += d.getDebit();
        }
        sum = sumAll;
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public boolean isIsAdd() {
        return isAdd;
    }

    public void setIsAdd(boolean isAdd) {
        this.isAdd = isAdd;
    }

    public Flat getHome() {
        return home;
    }

    public void setHome(Flat home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return id + ". " + firstNameOccupant + " " + lastNameOccupant;
    }
    
}
