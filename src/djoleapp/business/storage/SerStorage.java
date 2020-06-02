package djoleapp.business.storage;

import djoleapp.business.model.Administrator;
import djoleapp.business.model.BankAccount;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        } catch (IOException ex) {
            return new ArrayList<>();
        } catch (ClassNotFoundException ex) {
            Message.info(AlertType.ERROR, Constants.ALERT_ERROR_DIALOG, Constants.ERROR_STORAGE_LOAD_ADMIN);
            System.exit(0);
            return null;
        }
    }

    @Override
    public void writeAdmins(List<Administrator> list) {
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
        } catch (IOException ex) {
            return new ArrayList<>();
        } catch (ClassNotFoundException ex) {
            Message.info(AlertType.ERROR, Constants.ALERT_ERROR_DIALOG, Constants.ERROR_STORAGE_LOAD_BUILDING);
            System.exit(0);
            return null;
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

    @Override
    public List<Occupant> loadOccupants() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constants.OCCUPANTS_DAT));
            List<Occupant> list = (List<Occupant>) ois.readObject();
            ois.close();
            return list;
        } catch (IOException ex) {
            return new ArrayList();
        } catch (ClassNotFoundException ex) {
            Message.info(AlertType.ERROR, Constants.ALERT_ERROR_DIALOG, Constants.ERROR_STORAGE_LOAD_OCCUPANT);
            System.exit(0);
            return null;
        }
    }

    @Override
    public void writeOccupants(List<Occupant> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.OCCUPANTS_DAT));
            oos.writeObject(list);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            Message.info(AlertType.ERROR, Constants.ALERT_ERROR_DIALOG, Constants.ERROR_STORAGE_WRITE_OCCUPANT);
            System.exit(0);
        }
    }

}
