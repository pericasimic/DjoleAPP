package djoleapp.business.model;

import javafx.scene.text.Text;

public class ParkingSpace extends SeparateSection {

    public ParkingSpace(long id) {
        super(id);
    }

    public ParkingSpace(long id, Occupant occupant, int number, double surfaceArea, Text note) {
        super(id, occupant, number, surfaceArea, note);
    }

    
    
}
