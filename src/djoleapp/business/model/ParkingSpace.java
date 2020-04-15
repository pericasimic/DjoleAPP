package djoleapp.business.model;

import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class ParkingSpace extends SeparateSection {

    public ParkingSpace(long id, ResidentialCommunity residentialCommunity, String number, double surfaceArea, String note) {
        super(id, residentialCommunity, number, surfaceArea, note);
    }

  }
