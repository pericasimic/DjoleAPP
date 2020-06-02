package djoleapp.business.model;

import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class Garage extends SeparateSection {

    public Garage(ResidentialCommunity residentialCommunity, String number, double surfaceArea, String note) {
        super(residentialCommunity, number, surfaceArea, note);
    }

    @Override
    public String toString() {
        return super.getNumber() + super.getSurfaceArea() + super.getNote();
    }
}
