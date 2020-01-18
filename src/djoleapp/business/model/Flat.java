package djoleapp.business.model;

import java.util.List;
import javafx.scene.text.Text;

public class Flat extends SeparateSection {

    List<Occupant> listOccupants;

    public Flat(long id) {
        super(id);
    }

    public Flat(long id, Occupant occupant, int number, double surfaceArea, Text note, List<Occupant> listOccupants) {
        super(id, occupant, number, surfaceArea, note);
        this.listOccupants = listOccupants;

    }

    public List<Occupant> getListOccupants() {
        return listOccupants;
    }

    public void setListOccupants(List<Occupant> listOccupants) {
        this.listOccupants = listOccupants;
    }

}
