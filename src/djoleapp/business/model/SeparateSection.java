package djoleapp.business.model;

import java.io.Serializable;

public abstract class SeparateSection implements Serializable {

    private Occupant owner;
    private ResidentialCommunity residentialCommunity;
    private String number;
    private double surfaceArea;
    private String note;
    private boolean hasOwner = false;
    private boolean isExist = true;

  
    public SeparateSection() {
    }
    
    public SeparateSection(ResidentialCommunity residentialCommunity, String number, double surfaceArea, String note) {
        
        this.residentialCommunity = residentialCommunity;
        this.number = number;
        this.surfaceArea = surfaceArea;
        this.note = note;

    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Occupant getOwner() {
        return owner;
    }

    public void setOccupant(Occupant owner) {
        this.owner = owner;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public boolean isIsExist() {
        return isExist;
    }

    public void setIsExist(boolean isExist) {
        this.isExist = isExist;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ResidentialCommunity getResidentialCommunity() {
        return residentialCommunity;
    }

    public void setResidentialCommunity(ResidentialCommunity residentialCommunity) {
        this.residentialCommunity = residentialCommunity;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    
}
