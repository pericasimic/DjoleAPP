package djoleapp.business.model;

import java.util.ArrayList;
import java.util.List;

public class Flat extends SeparateSection {

 public Flat(ResidentialCommunity residentialCommunity, String number, double surfaceArea, String note) {
        super(residentialCommunity, number, surfaceArea, note);
    }

    @Override
    public String toString() {
        return "Stan broj " + super.getNumber()+ " / " + super.getResidentialCommunity().getName();
    }

}
