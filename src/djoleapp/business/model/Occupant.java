package djoleapp.business.model;

import javafx.scene.text.Text;

public class Occupant {
    
    private String firstNameOccupant;
    private String lastNameOccupant;
    private String identificationNumber;
    private String phoneNumber;
    private String mail;
    private Text note;
    private boolean isExist;

    public Occupant() {
        this.isExist = true;
    }

    public Occupant(String firstNameOccupant, String lastNameOccupant, String identificationNumber, String phoneNumber, String mail, Text note) {
        this.firstNameOccupant = firstNameOccupant;
        this.lastNameOccupant = lastNameOccupant;
        this.identificationNumber = identificationNumber;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.note = note;
        this.isExist = true;
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

    public Text getNote() {
        return note;
    }

    public void setNote(Text note) {
        this.note = note;
    }

    public boolean isIsExist() {
        return isExist;
    }

    public void setIsExist(boolean isExist) {
        this.isExist = isExist;
    }

    
    
    
}
