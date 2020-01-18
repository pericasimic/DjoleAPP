package djoleapp.business.model;

import javafx.scene.text.Text;

public class ParkingBox extends SeparateSection {

    public ParkingBox(long id) {
        super(id);
    }

    public ParkingBox(long id, Occupant occupant, int number, double surfaceArea, Text note) {
        super(id, occupant, number, surfaceArea, note);
    }

}
