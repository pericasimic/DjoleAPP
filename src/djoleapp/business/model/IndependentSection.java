package djoleapp.business.model;

import java.io.Serializable;

public class IndependentSection implements Serializable {

    private String name;
    private String note;
    private Occupant owner;
    private double pricePerMonth;

    public IndependentSection(String name) {
        this.name = name;
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
    
    

}
