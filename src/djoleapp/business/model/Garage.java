package djoleapp.business.model;

import javafx.scene.text.Text;

public class Garage extends SeparateSection {

    public Garage(long id) {
        super(id);
    }

    public Garage(long id, Occupant occupant, int number, double surfaceArea, Text note) {
        super(id, occupant, number, surfaceArea, note);
    }

   
}
