package djoleapp.business.model;

import javafx.scene.text.Text;

public abstract class SeparateSection {

    private long id;
    private Occupant occupant;
    private int number;
    private double surfaceArea;
    private Text note;
    private double debit = 0;
    private boolean isExist = true;

    public SeparateSection(long id) {
        this.id = id;
    }

    public SeparateSection(long id, Occupant occupant, int number, double surfaceArea, Text note) {
        this.id = id;
        this.occupant = occupant;
        this.number = number;
        this.surfaceArea = surfaceArea;
        this.note = note;

    }

    public Text getNote() {
        return note;
    }

    public void setNote(Text note) {
        this.note = note;
    }

    public Occupant getOccupant() {
        return occupant;
    }

    public void setOccupant(Occupant occupant) {
        this.occupant = occupant;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
}
