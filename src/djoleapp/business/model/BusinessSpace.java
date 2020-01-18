package djoleapp.business.model;

import javafx.scene.text.Text;

public class BusinessSpace extends SeparateSection {

    public BusinessSpace(long id) {
        super(id);
    }

    public BusinessSpace(long id, Occupant occupant, int number, double surfaceArea, Text note) {
        super(id, occupant, number, surfaceArea, note);
    }

   
}
