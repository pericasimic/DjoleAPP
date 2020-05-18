package djoleapp.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class Flat extends SeparateSection {

    List<Occupant> listOccupants = new ArrayList<>();

    public Flat(long id, ResidentialCommunity residentialCommunity, String number, double surfaceArea, String note) {
        super(id, residentialCommunity, number, surfaceArea, note);
    }

    public List<Occupant> getListOccupants() {
        return listOccupants;
    }

    public void setListOccupants(List<Occupant> listOccupants) {
        this.listOccupants = listOccupants;
    }

    @Override
    public String toString() {
        return super.getId() + super.getNumber() + super.getSurfaceArea() + super.getNote();
    }

}
