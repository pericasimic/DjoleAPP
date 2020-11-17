package djoleapp.business.facade;

import djoleapp.DjoleAPP;
import djoleapp.business.Factory;
import djoleapp.business.model.AccountCalculation;
import djoleapp.business.model.Administrator;
import djoleapp.business.model.BankAccount;
import djoleapp.business.model.BusinessSpace;
import djoleapp.business.model.CommonSection;
import djoleapp.business.model.Debit;
import djoleapp.business.model.Flat;
import djoleapp.business.model.Garage;
import djoleapp.business.model.IndependentSection;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ParkingBox;
import djoleapp.business.model.ParkingSpace;
import djoleapp.business.model.PaymentItems;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import djoleapp.gui.admingui.AddAdminPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author perica.simic
 */
public class FacadeSER implements Facade {

    @Override
    public boolean loginAdminCheck(String username, String password) {

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            return false;
        }

        List<Administrator> list = Factory.getStorage().loadAdmin();

        if (username.equals(Constants.ADMIN) && password.equals(Constants.ADMIN) && list.isEmpty()) {
            AddAdminPane aap = new AddAdminPane();
            Controller.getInstance().setAddAdminPane(aap);
            Scene scena = new Scene(aap, Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
            scena.getStylesheets().add(DjoleAPP.class.getResource(Constants.STYLE_PATH).toExternalForm());
            Controller.getInstance().getPrimaryStage().setScene(scena);
            return false;
        }

        if (username.equals(Constants.ADMIN) && password.equals(Constants.ADMIN) && !list.isEmpty()) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ADMIN_EXISTS);
            return false;
        }

        for (Administrator a : list) {
            if (username.equals(a.getUsername()) && password.equals(a.getPassword())) {
                return true;
            }
        }
        Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ADMIN_LOGIN_FAILD);
        return false;

    }

    @Override
    public boolean checkAddAdmin(String username, String password, String conPass) {
        if (username == null || password == null || conPass == null || username.isEmpty() || password.isEmpty() || conPass.isEmpty()) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            return false;
        }
        if (username.equalsIgnoreCase(Constants.ADMIN)) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ADMIN_DENY);
            return false;
        }
        if (!password.equals(conPass)) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_PASSWORD_NOT_SAME);
            return false;
        }
        return true;
    }

    @Override
    public List<Occupant> getListfreeOccupants() {
        List<Occupant> list = new ArrayList<>();
        for (Occupant o : Controller.getInstance().getTemporaryList().getOccupants()) {
            if (!o.isIsAdd()) {
                list.add(o);
            }
        }
        return list;
    }

    @Override
    public double supportSum(double price, double area) {
        return price * area;
    }

    @Override
    public String kindOfSection(SeparateSection section) {
        if (section instanceof ParkingBox) {
            return Constants.GARAGE_BOX;
        }
        if (section instanceof ParkingSpace) {
            return Constants.GARAGE_SPACE;
        }
        if (section instanceof Garage) {
            return Constants.GARAGE;
        }
        if (section instanceof BusinessSpace) {
            return Constants.BUSINESS_SPACE;
        }
        if (section instanceof Flat) {
            return Constants.FLAT;
        }
        return null;
    }

    /*SearchBuildingEvent*/
    @Override
    public List<ResidentialCommunity> searchBuidingList(String word) {
        List<ResidentialCommunity> list = new ArrayList<>();
        for (ResidentialCommunity rc : Controller.getInstance().getTemporaryList().getResidentialCommunitys()) {
            if (rc.getName().contains(word) || rc.getIdentificationNumber().contains(word) || rc.getTaxIdentificationNumber().contains(word) || rc.getMail().contains(word)) {
                list.add(rc);
            }
        }
        return list;
    }

    /*AddBuildingEvent*/
    @Override
    public boolean checkAddBuildingFieldsEmpty(String name, String number, String city, String idNum, String taxNum, String mail) {
        if (name.isEmpty() || name == null || number.isEmpty() || number == null || city.isEmpty() || city == null || idNum.isEmpty() || idNum == null || taxNum.isEmpty() || taxNum == null || mail.isEmpty() || mail == null) {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            return true;
        }
        return false;
    }

    /*AddBuildingEvent*/
    @Override
    public boolean checkAddBuildingFieldExist(String name, String number, String city, String idNum, String taxNum, String mail) {

        for (ResidentialCommunity rc : Controller.getInstance().getTemporaryList().getResidentialCommunitys()) {
            if ((rc.getName() + rc.getNumber()).replaceAll("\\s+", "").equalsIgnoreCase(name.replaceAll("\\s+", "")) || rc.getIdentificationNumber().replaceAll("\\s+", "").equalsIgnoreCase(idNum.replaceAll("\\s+", ""))
                    || rc.getTaxIdentificationNumber().replaceAll("\\s+", "").equalsIgnoreCase(taxNum.replaceAll("\\s+", "")) || rc.getMail().replaceAll("\\s+", "").equalsIgnoreCase(mail.replaceAll("\\s+", ""))) {
                Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_BUILDING_EXIST);
                return true;
            }
        }
        return false;

    }

    /*AddBuildingEvent*/
    @Override
    public boolean validateEmail(String emailStr) {
        Pattern pattern = Pattern.compile(Constants.VALID_EMAIL_ADDRESS_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailStr);
        if (matcher.find()) {
            return true;
        } else {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.BAD_FORMAT_FOR_EMAIL);
            return false;
        }

    }

    /*AddBuildingEvent*/
    @Override
    public boolean validTaxNumber(String taxNumber) {
        if (taxNumber.matches(Constants.VALID_NUMBER) && taxNumber.length() == 9) {
            return true;
        } else {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.BAD_FORMAT_FOR_TAX_NUMBER);
            return false;
        }
    }

    /*AddBuildingEvent*/
    @Override
    public boolean validIDNumber(String idNumber) {
        if (idNumber.matches(Constants.VALID_NUMBER) && idNumber.length() == 8) {
            return true;
        } else {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.BAD_FORMAT_FOR_ID_NUMBER);
            return false;
        }
    }

    /*RemoveBuildingEvent*/
    @Override
    public boolean removeBuilding(ResidentialCommunity rc) {

        if (rc == null) {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_NOT_SELECT);
            return false;
        }

        Controller.getInstance().getTemporaryList().getResidentialCommunitys().remove(rc);
        return true;
    }

    @Override
    public boolean removeBankAccount(BankAccount ba, ResidentialCommunity rc) {

        if (ba == null) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_NOT_SELECT);
            return false;
        }
        rc.getBankAccounts().remove(ba);
        return true;
    }

    @Override
    public boolean checkBankAccount(String name, String number) {

        if (name.isEmpty() || name == null || number.isEmpty() || number == null) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            return false;
        }

        for (ResidentialCommunity rc : Controller.getInstance().getTemporaryList().getResidentialCommunitys()) {
            for (BankAccount ba : rc.getBankAccounts()) {
                if (ba.getBankAccountNumber().equalsIgnoreCase(number)) {
                    Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_ACCOUNT_EXIST);
                    return false;
                }
            }
        }
        for (Occupant o : Controller.getInstance().getTemporaryList().getOccupants()) {
            for (BankAccount b : o.getBankAccounts()) {
                if (b.getBankAccountNumber().equalsIgnoreCase(number)) {
                    Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_ACCOUNT_EXIST);
                    return false;
                }
            }
        }

        return true;

    }

    @Override
    public boolean addSeparateSection(boolean isAdd, ResidentialCommunity rc, String section, String number, String areaSection, String note, Occupant owner) {
        
        SeparateSection sep = Controller.getInstance().getTemporarySeparateSection();
        double area = 0;

        if (rc == null || section.isEmpty() || section == null || number.isEmpty() || number == null || areaSection == null || areaSection.isEmpty() || note.isEmpty() || note == null) {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            return false;
        }

        try {
            double value = Double.valueOf(areaSection);
            area = value;
        } catch (NumberFormatException nfe) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.BAD_FORMAT_AREA);
            return false;
        }

        if (section.equals(Constants.FLAT)) {
            for (SeparateSection s : rc.getListSeparationSection()) {
                if (s instanceof Flat) {
                    if (s.getNumber().equalsIgnoreCase(number) && isAdd) {
                        Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.NUMBER_SECTION_EXIST);
                        return false;
                    }
                    if (s.getNumber().equalsIgnoreCase(number) && !isAdd && !sep.getNumber().equalsIgnoreCase(number)) {
                        Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.NUMBER_SECTION_EXIST);
                        return false;
                    }

                }
            }
            if (isAdd) {
                SeparateSection ss = new Flat(rc, number, area, note);
                if (owner != null) {
                    ss.setOccupant(owner);
                    ss.setHasOwner(true);
                }
                rc.getListSeparationSection().add(ss);
                Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_NEW_SECTION);
            } else {
                sep.setNumber(number);
                sep.setSurfaceArea(area);
                sep.setNote(note);
                if (owner != null) {
                    sep.setOccupant(owner);
                    sep.setHasOwner(true);
                }
                if (sep.getResidentialCommunity() != rc) {
                    sep.setResidentialCommunity(rc);
                    rc.getListSeparationSection().add(sep);
                    Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getListSeparationSection().remove(sep);
                }
                Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.MODIFIED_SECTION);
            }

        }

        if (section.equals(Constants.GARAGE)) {
            for (SeparateSection s : rc.getListSeparationSection()) {
                if (s.getNumber().equalsIgnoreCase(number)) {
                    if (s instanceof Garage) {
                        Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.NUMBER_SECTION_EXIST);
                        return false;
                    }
                    if (s.getNumber().equalsIgnoreCase(number) && !isAdd && !sep.getNumber().equalsIgnoreCase(number)) {
                        Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.NUMBER_SECTION_EXIST);
                        return false;
                    }
                }
            }
            if (isAdd) {
                SeparateSection ss = new Garage(rc, number, area, note);
                if (owner != null) {
                    ss.setOccupant(owner);
                    ss.setHasOwner(true);
                }
                rc.getListSeparationSection().add(ss);
                Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_NEW_SECTION);
            } else {
                sep.setNumber(number);
                sep.setSurfaceArea(area);
                sep.setNote(note);
                if (owner != null) {
                    sep.setOccupant(owner);
                    sep.setHasOwner(true);
                }
                if (sep.getResidentialCommunity() != rc) {
                    sep.setResidentialCommunity(rc);
                    rc.getListSeparationSection().add(sep);
                    Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getListSeparationSection().remove(sep);
                }
                Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.MODIFIED_SECTION);
            }

        }

        if (section.equals(Constants.BUSINESS_SPACE)) {
            for (SeparateSection s : rc.getListSeparationSection()) {
                if (s.getNumber().equalsIgnoreCase(number)) {
                    if (s instanceof BusinessSpace) {
                        Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.NUMBER_SECTION_EXIST);
                        return false;
                    }
                    if (s.getNumber().equalsIgnoreCase(number) && !isAdd && !sep.getNumber().equalsIgnoreCase(number)) {
                        Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.NUMBER_SECTION_EXIST);
                        return false;
                    }
                }
            }
            if (isAdd) {
                SeparateSection ss = new BusinessSpace(rc, number, area, note);
                if (owner != null) {
                    ss.setOccupant(owner);
                    ss.setHasOwner(true);
                }
                rc.getListSeparationSection().add(ss);
                Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_NEW_SECTION);
            } else {
                sep.setNumber(number);
                sep.setSurfaceArea(area);
                sep.setNote(note);
                if (owner != null) {
                    sep.setOccupant(owner);
                    sep.setHasOwner(true);
                }
                if (sep.getResidentialCommunity() != rc) {
                    sep.setResidentialCommunity(rc);
                    rc.getListSeparationSection().add(sep);
                    Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getListSeparationSection().remove(sep);
                }
                Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.MODIFIED_SECTION);
            }

        }

        if (section.equals(Constants.GARAGE_BOX)) {
            for (SeparateSection s : rc.getListSeparationSection()) {
                if (s.getNumber().equalsIgnoreCase(number)) {
                    if (s instanceof ParkingBox) {
                        Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.NUMBER_SECTION_EXIST);
                        return false;
                    }
                    if (s.getNumber().equalsIgnoreCase(number) && !isAdd && !sep.getNumber().equalsIgnoreCase(number)) {
                        Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.NUMBER_SECTION_EXIST);
                        return false;
                    }
                }
            }
            if (isAdd) {
                SeparateSection ss = new ParkingBox(rc, number, area, note);
                if (owner != null) {
                    ss.setOccupant(owner);
                    ss.setHasOwner(true);
                }
                rc.getListSeparationSection().add(ss);
                Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_NEW_SECTION);
            } else {
                sep.setNumber(number);
                sep.setSurfaceArea(area);
                sep.setNote(note);
                if (owner != null) {
                    sep.setOccupant(owner);
                    sep.setHasOwner(true);
                }
                if (sep.getResidentialCommunity() != rc) {
                    sep.setResidentialCommunity(rc);
                    rc.getListSeparationSection().add(sep);
                    Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getListSeparationSection().remove(sep);
                }
                Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.MODIFIED_SECTION);
            }

        }

        if (section.equals(Constants.GARAGE_SPACE)) {
            for (SeparateSection s : rc.getListSeparationSection()) {
                if (s.getNumber().equalsIgnoreCase(number)) {
                    if (s instanceof ParkingSpace) {
                        Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.NUMBER_SECTION_EXIST);
                        return false;
                    }
                    if (s.getNumber().equalsIgnoreCase(number) && !isAdd && !sep.getNumber().equalsIgnoreCase(number)) {
                        Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.NUMBER_SECTION_EXIST);
                        return false;
                    }
                }
            }
            if (isAdd) {
                SeparateSection ss = new ParkingSpace(rc, number, area, note);
                if (owner != null) {
                    ss.setOccupant(owner);
                    ss.setHasOwner(true);
                }
                rc.getListSeparationSection().add(ss);
                Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_NEW_SECTION);
            } else {
                sep.setNumber(number);
                sep.setSurfaceArea(area);
                sep.setNote(note);
                if (owner != null) {
                    sep.setOccupant(owner);
                    sep.setHasOwner(true);
                }
                if (sep.getResidentialCommunity() != rc) {
                    sep.setResidentialCommunity(rc);
                    rc.getListSeparationSection().add(sep);
                    Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getListSeparationSection().remove(sep);
                }
                Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.MODIFIED_SECTION);
            }

        }

        Controller.getInstance().getTemporaryStage().close();
        if (Controller.getInstance().getManagerEvent().getEditSeparationEvent().getStage() != null) {
            Controller.getInstance().getManagerEvent().getEditSeparationEvent().getStage().close();
        }
        Controller.getInstance().getManagerEvent().getAddSectionEvent().setScene();
        return true;
    }

    @Override
    public void removeSeparateSection(SeparateSection ss, ResidentialCommunity rc) {

        if (ss == null || rc == null) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_NOT_SELECT);
            return;
        }

        rc.getListSeparationSection().remove(ss);
        Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.SUCCESS_DELETE);

    }

    @Override
    public void addIndSection(String name, String note, Occupant owner, String price, ResidentialCommunity residentialCommunity) {

        if (name == null || name.isEmpty()) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.HAVE_TO_NAME_INDEPENDENT);
            return;
        }
        IndependentSection ipSection = new IndependentSection(name, residentialCommunity);
        ipSection.setNote(note);

        if (price != null || !price.isEmpty()) {
            try {
                double priceSec = Double.valueOf(price);
                ipSection.setPricePerMonth(priceSec);
            } catch (NumberFormatException nfe) {
                Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.BAD_FORMAT_PER_MONTH);
                return;
            }
        }

        if (owner != null) {
            ipSection.setOwner(owner);
        }

        Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getListIndependentSections().add(ipSection);
        Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_NEW_SECTION);
        Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent().showSelectBuildTableEvent();

    }

    @Override
    public void removeIndSection(IndependentSection independentSection) {
        if (independentSection == null) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_NOT_SELECT);
            return;
        }

        Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getListIndependentSections().remove(independentSection);
        Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.SUCCESS_DELETE);
        Controller.getInstance().getListIndependentSectionsPane().reload(Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getListIndependentSections());
    }

    @Override
    public void removeCommonSection(CommonSection commonSection) {
        if (commonSection == null) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_NOT_SELECT);
            return;
        }

        Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getListCommonSections().remove(commonSection);
        Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.SUCCESS_DELETE);
        Controller.getInstance().getListCommonSectionPane().reload(Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getListCommonSections());
    }

    @Override
    public void addCommonSection(String name, String note, String price) {
        if (name == null || name.isEmpty()) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.HAVE_TO_NAME_COMMON);
            return;
        }
        CommonSection commonSection = new CommonSection(name);
        commonSection.setNote(note);

        if (price != null || !price.isEmpty()) {
            try {
                double priceSec = Double.valueOf(price);
                commonSection.setPricePerMonth(priceSec);
            } catch (NumberFormatException nfe) {
                Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.BAD_FORMAT_PER_MONTH);
                return;
            }
        }

        Controller.getInstance().getTopHBoxBuildingPane().getBuildingsBox().getValue().getListCommonSections().add(commonSection);
        Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_NEW_SECTION);
        Controller.getInstance().getManagerEvent().getShowSelectBuildTableEvent().showSelectBuildTableEvent();
    }

    /*OccupantDetailsBuildingPane*/
    @Override
    public List<Flat> getFlats(ResidentialCommunity r) {
        List<Flat> list = new ArrayList<>();

        for (SeparateSection s : r.getListSeparationSection()) {
            if (s instanceof Flat) {
                list.add((Flat) s);
            }
        }
        return list;
    }

    /*RemoveBuildingOccupantEvent*/
    @Override
    public void removeBuildingOccupant(ResidentialCommunity rc, Occupant o) {
        if (rc == null || o == null) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_NOT_SELECT);
            return;
        }

        rc.getListOccupants().remove(o);
        o.setIsAdd(false);
        o.setHome(null);

        Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.SUCCESS_DELETE);
    }

    /*AddOccupantBuildingEvent*/
    @Override
    public void addOccupantBuilding(ResidentialCommunity rc, Occupant o, SeparateSection ss) {

        if (rc == null || o == null || ss == null) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_NOT_SELECT);
            return;
        }

        
        o.setIsAdd(true);
        o.setHome((Flat) ss);
        rc.getListOccupants().add(o);
        Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_OCCUPANT_SUCCESS);

    }

    @Override
    public List<Occupant> searchUserList(String word) {
        List<Occupant> list = new ArrayList<>();
        for (Occupant o : Controller.getInstance().getTemporaryList().getOccupants()) {
            if (o.getFirstNameOccupant().contains(word) || o.getLastNameOccupant().contains(word) || o.getPhoneNumber().contains(word) || o.getMail().contains(word) || o.getIdentificationNumber().contains(word) || (o.getHome() != null && o.getHome().toString().contains(word))) {
                list.add(o);
            }
        }
        return list;
    }

    @Override
    public void removeOccupant(Occupant o) {
        if (o != null) {
            List<ResidentialCommunity> residentialCommunitys = new ArrayList<>();

            for (ResidentialCommunity rc : Controller.getInstance().getTemporaryList().getResidentialCommunitys()) {
                if (rc.getListOccupants().isEmpty() || rc.getListOccupants() != null) {
                    List<Occupant> resList = new ArrayList<>();
                    for (Occupant oc : rc.getListOccupants()) {
                        if (oc.getId() != o.getId()) {
                            resList.add(oc);
                        }

                    }
                    rc.setListOccupants(resList);
                    residentialCommunitys.add(rc);
                }

                for (SeparateSection ss : rc.getListSeparationSection()) {
                    if (ss.getOwner() != null) {
                        if (ss.getOwner().getId() == o.getId()) {
                            ss.setHasOwner(false);
                            ss.setOccupant(null);
                        }
                    }

                }

                for (IndependentSection is : rc.getListIndependentSections()) {
                    if (is.getOwner() != null) {
                        if (is.getOwner().getId() == o.getId()) {
                            is.setOwner(null);
                        }
                    }

                }

            }
            Controller.getInstance().getTemporaryList().getOccupants().remove(o);
            Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.SUCCESS_DELETE);
        } else {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_NOT_SELECT);
            return;
        }
    }

    @Override
    public void writeId(long id) {
        File file = new File(Constants.COUNT_ID_OCCUPANT);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(String.valueOf(id));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public long readId() {
        long result = 0;
        try {
            File myObj = new File(Constants.COUNT_ID_OCCUPANT);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result = Long.valueOf(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean addOccupant(long id, String firstName, String lastName, String idNum, String phone, String mail, String note) {

        if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() || idNum.isEmpty() || idNum == null || phone.isEmpty() || phone == null || mail.isEmpty() || mail == null) {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT_OCCUPANT);
            return false;
        }

        for (Occupant o : Controller.getInstance().getTemporaryList().getOccupants()) {
            if (o.getIdentificationNumber().equalsIgnoreCase(idNum)) {
                Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.OCCUPANT_IDNUM_EXIST);
                return false;

            }

        }

        Occupant o = new Occupant(id, firstName, lastName, idNum, phone, mail);

        if (!note.isEmpty()) {
            o.setNote(note);
        }
        Controller.getInstance().getTemporaryList().getOccupants().add(o);
        return true;

    }

    @Override
    public List<Occupant> getListOccupantsPerFlat(Flat flat) {

        List<Occupant> result = new ArrayList<>();

        for (Occupant o : Controller.getInstance().getTemporaryList().getOccupants()) {
            if (o.getHome() != null && o.getHome().equals(flat)) {
                result.add(o);
            }
        }

        return result;
    }

    @Override
    public boolean createBankAccountOccupant(String name, String number) {

        if (name == null || name.isEmpty() || number == null || number.isEmpty()) {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            return false;
        }
        BankAccount bankAccount = new BankAccount(name, number);
        Controller.getInstance().getTemporaryOccupant().getBankAccounts().add(bankAccount);
        Message.info(AlertType.INFORMATION, Constants.ALERT_INFORMATION_DIALOG, Constants.ADD_BANK_ACCOUNT_SUCCESS);
        return true;
    }

    @Override
    public List<SeparateSection> getSeparateSectionPerOccupant(Occupant o) {

        List<SeparateSection> result = new ArrayList<>();

        for (ResidentialCommunity rc : Controller.getInstance().getTemporaryList().getResidentialCommunitys()) {
            for (SeparateSection ss : rc.getListSeparationSection()) {
                if (ss.getOwner() != null && ss.getOwner().getId() == o.getId()) {
                    result.add(ss);
                }
            }
        }

        return result;
    }

    @Override
    public List<IndependentSection> getIndSectionPerOccupant(Occupant o) {
        List<IndependentSection> result = new ArrayList<>();

        for (ResidentialCommunity rc : Controller.getInstance().getTemporaryList().getResidentialCommunitys()) {
            for (IndependentSection is : rc.getListIndependentSections()) {
                if (is.getOwner().getId() == o.getId()) {
                    result.add(is);
                }
            }
        }

        return result;
    }

    @Override
    public double pricePerArea(SeparateSection section) {

        if (section instanceof ParkingBox) {
            return Controller.getInstance().getPricePerMonthBox();
        }
        if (section instanceof ParkingSpace) {
            return Controller.getInstance().getPricePerMonthSpace();
        }
        if (section instanceof Garage) {
            return Controller.getInstance().getPricePerMonthGarage();
        }
        if (section instanceof BusinessSpace) {
            return Controller.getInstance().getPricePerMonthBusiness();
        }
        if (section instanceof Flat) {
            return Controller.getInstance().getPricePerMonthFlat();
        }

        return -1;
    }

    @Override
    public List<PaymentItems> getListPayment(ResidentialCommunity residentialCommunity, Occupant occupant) {

        List<SeparateSection> listSections = new ArrayList<>();
        List<PaymentItems> result = new ArrayList<>();

        for (SeparateSection ss : residentialCommunity.getListSeparationSection()) {
            if (ss.getOwner().getId() == occupant.getId()) {
                listSections.add(ss);
            }
        }

        for (SeparateSection section : listSections) {
            result.add(new PaymentItems(section));
        }

        return result;
    }

    @Override
    public void createNewCalculations() {

        for (Occupant o : Controller.getInstance().getTemporaryList().getOccupants()) {
            o.getSections().clear();
        }

        Date currentDate = new Date();
        Date deadlineDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        deadlineDate = calendar.getTime();

        for (ResidentialCommunity rc : Controller.getInstance().getTemporaryList().getResidentialCommunitys()) {
            for (SeparateSection ss : rc.getListSeparationSection()) {
                for (Occupant o : Controller.getInstance().getTemporaryList().getOccupants()) {
                    if (ss.getOwner() != null && ss.getOwner().getId() == o.getId()) {
                        o.getSections().add(ss);
                    }
                }
            }
        }

        for (ResidentialCommunity rc : Controller.getInstance().getTemporaryList().getResidentialCommunitys()) {
            for (Occupant o : Controller.getInstance().getTemporaryList().getOccupants()) {
                if (!o.getSections().isEmpty()) {
                    List<PaymentItems> itemses = new ArrayList<>();
                    for (SeparateSection s : o.getSections()) {
                        if (s.getResidentialCommunity().getTaxIdentificationNumber().equalsIgnoreCase(rc.getTaxIdentificationNumber())) {
                            PaymentItems paymentItems = new PaymentItems(s);
                            itemses.add(paymentItems);
                        }
                    }

                    double sumItems = 0;
                    for (PaymentItems p : itemses) {
                        sumItems += p.getSum();
                    }

                    double preDebit = 0;
                    boolean empty = true;

                    for (Debit d : o.getDebits()) {
                        if (d.getResidentialCommunity().getTaxIdentificationNumber().equalsIgnoreCase(rc.getTaxIdentificationNumber())) {
                            preDebit = d.getDebit();
                            d.setDebit(preDebit + sumItems);
                            empty = false;
                        }
                    }

                    if (empty == true) {
                        Debit debit = new Debit(rc, sumItems);
                        o.getDebits().add(debit);
                    }

                    AccountCalculation ac = new AccountCalculation(rc, o, Factory.getFacade().numberCalculation(rc, o,
                            currentDate), currentDate, deadlineDate, itemses, sumItems, preDebit, sumItems + preDebit);
                    ac.setMonth(Factory.getFacade().returnMonth(calendar.get(Calendar.MONTH)));
                    o.getListAccountCalc().add(ac);
                }
            }
        }

        //    int month = cal.get(Calendar.MONTH);
        //    int curentDay = cal.get(Calendar.DAY_OF_MONTH);
        //
        //    if (curentDay
        //
        //    
        //        == 31) {
        //            System.out.println("Mesec ima 31 dan");
        //        return;
        //    }
        //
        //    if (curentDay == 30 && (month == 4 || month == 6
        //                || month == 9 || month
        //
        //    
        //        == 11)) {
        //            System.out.println("Mesec ima 30 dan");
        //        return;
        //    }
        //
        //    if (month == 2 && (curentDay == 28 || curentDay
        //
        //    
        //        == 29)) {
        //            System.out.println("Mesec je februar");
        //        return;
        //    }
        //
        //    System.out.println (
        //
        //"Trenutno je " + curentDay + "-i dan u mesecu");
    }

    @Override
    public String returnMonth(int num) {

        switch (num) {
            case 1:
                return Constants.JANUARY;
            case 2:
                return Constants.FEBRUARY;
            case 3:
                return Constants.MARCH;
            case 4:
                return Constants.APRIL;
            case 5:
                return Constants.MAY;
            case 6:
                return Constants.JUNE;
            case 7:
                return Constants.JULY;
            case 8:
                return Constants.AUGUST;
            case 9:
                return Constants.SEPTEMBER;
            case 10:
                return Constants.OCTOBER;
            case 11:
                return Constants.NOVEMBER;
            case 12:
                return Constants.DECEMBER;
        }
        return Constants.EMPTY_STRING;
    }

    @Override
    public String numberCalculation(ResidentialCommunity residentialCommunity, Occupant o, Date date) {
        String firstTwo = "";
        if (residentialCommunity.getName().length() > 2) {
            firstTwo = residentialCommunity.getName().substring(0, 2);
        }
        String pattern = "M-yy";
        DateFormat df = new SimpleDateFormat(pattern);
        date = Calendar.getInstance().getTime();
        String todayAsString = df.format(date);
        return firstTwo.toUpperCase() + residentialCommunity.getNumber() + " - " + o.getId() + " - " + todayAsString;
    }

    @Override
    public String getDateFormat(Date date) {
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    @Override
    public void changeCalculationSum(AccountCalculation ac, double sum) {
        double curentNew = 0;
        for (Debit d : ac.getOccupant().getDebits()) {
            if (d.getResidentialCommunity().getTaxIdentificationNumber().equalsIgnoreCase(ac.getResidentialCommunity().getTaxIdentificationNumber())) {
                double changedSum = d.getDebit() - sum;
                d.setDebit(changedSum);
                curentNew = changedSum;
                break;
            }
        }
        ac.setDebitCurentMonth(sum);
        ac.setSum(curentNew);

    }

    @Override
    public boolean editOccupant(String firstName, String lastName, String idNum, String phone, String mail, String note) {

        Occupant occupant = Controller.getInstance().getTemporaryOccupant();
        if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() || idNum.isEmpty() || idNum == null || phone.isEmpty() || phone == null || mail.isEmpty() || mail == null) {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT_OCCUPANT);
            return false;
        }

        for (Occupant o : Controller.getInstance().getTemporaryList().getOccupants()) {
            if (o.getIdentificationNumber().equalsIgnoreCase(idNum) && o != occupant) {
                Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.OCCUPANT_IDNUM_EXIST);
                return false;

            }

        }

        occupant.setFirstNameOccupant(firstName);
        occupant.setLastNameOccupant(lastName);
        occupant.setIdentificationNumber(idNum);
        occupant.setPhoneNumber(phone);
        occupant.setMail(mail);

        if (!note.isEmpty()) {
            occupant.setNote(note);
        }

        return true;
    }

}
