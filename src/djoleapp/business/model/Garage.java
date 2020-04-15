package djoleapp.business.model;

import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class Garage extends SeparateSection {

    public Garage(long id, ResidentialCommunity residentialCommunity, String number, double surfaceArea, String note) {
        super(id, residentialCommunity, number, surfaceArea, note);
    }

}
