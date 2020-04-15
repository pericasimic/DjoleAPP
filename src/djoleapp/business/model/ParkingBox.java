package djoleapp.business.model;

import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class ParkingBox extends SeparateSection {

    public ParkingBox(long id, ResidentialCommunity residentialCommunity, String number, double surfaceArea, String note) {
        super(id, residentialCommunity, number, surfaceArea, note);
    }


}
