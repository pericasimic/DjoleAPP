package djoleapp.business.model;

import java.io.Serializable;

public class IndependentSection implements Serializable {

    private String name;
    private String note;
    private ResidentialCommunity residentialCommunity;
    private Occupant owner;
    private double pricePerMonth;

    public IndependentSection(String name, ResidentialCommunity residentialCommunity) {
        this.name = name;
        this.residentialCommunity = residentialCommunity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Occupant getOwner() {
        return owner;
    }

    public void setOwner(Occupant owner) {
        this.owner = owner;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public ResidentialCommunity getResidentialCommunity() {
        return residentialCommunity;
    }

    public void setResidentialCommunity(ResidentialCommunity residentialCommunity) {
        this.residentialCommunity = residentialCommunity;
    }
    
    

}
