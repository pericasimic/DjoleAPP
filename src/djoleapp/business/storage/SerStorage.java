package djoleapp.business.storage;

import djoleapp.business.model.Administrator;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
            Message.info(AlertType.ERROR, Constants.ALERT_ERROR_DIALOG, Constants.ERROR_STORAGE);
            System.exit(0);
            return null;
        }
    }
    
    @Override
    public void writeAdmin(List<Administrator> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.ADMIN_DAT));
            oos.writeObject(list);
            oos.close();
        } catch (Exception ex) {
            Message.info(AlertType.ERROR, Constants.ALERT_ERROR_DIALOG, Constants.ERROR_STORAGE);
            System.exit(0);
        }
    }
    
}
