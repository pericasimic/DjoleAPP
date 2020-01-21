package djoleapp.business.storage;

import djoleapp.business.model.Administrator;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert.AlertType;

public class SerStorage implements Storage {

    @Override
    public List<Administrator> loadAdmin() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constants.ADMIN_DAT));
            List<Administrator> list = (List<Administrator>) ois.readObject();
            ois.close();
            return list;
        } catch (Exception ex) {
            Message.info(AlertType.ERROR, Constants.ALERT_ERROR_DIALOG, Constants.ERROR_STORAGE_LOAD_ADMIN);
            System.exit(0);
            return new ArrayList<>();
        }
    }

    @Override
    public void writeAdmin(List<Administrator> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.ADMIN_DAT));
            oos.writeObject(list);
            oos.close();
        } catch (Exception ex) {
            Message.info(AlertType.ERROR, Constants.ALERT_ERROR_DIALOG, Constants.ERROR_STORAGE_WRITE_ADMIN);
            System.exit(0);
        }
    }

    @Override
    public List<ResidentialCommunity> loadResidentialCommunities() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constants.BUILDINGS_DAT));
            List<ResidentialCommunity> list = (List<ResidentialCommunity>) ois.readObject();
            ois.close();
            return list;
        } catch (Exception ex) {
            Message.info(AlertType.ERROR, Constants.ALERT_ERROR_DIALOG, Constants.ERROR_STORAGE_LOAD_BUILDING);
            System.exit(0);
            return new ArrayList<>();
        }
    }

    @Override
    public void writeResidentialCommunities(List<ResidentialCommunity> list) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.BUILDINGS_DAT));
            oos.writeObject(list);
            oos.close();
        } catch (Exception ex) {
            Message.info(AlertType.ERROR, Constants.ALERT_ERROR_DIALOG, Constants.ERROR_STORAGE_WRITE_BUILDING);
            System.exit(0);
        }

    }

}
