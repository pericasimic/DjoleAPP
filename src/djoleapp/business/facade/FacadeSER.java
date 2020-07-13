package djoleapp.business.facade;

import djoleapp.business.Factory;
import djoleapp.business.model.Administrator;
import djoleapp.business.model.BankAccount;
import djoleapp.business.model.BusinessSpace;
import djoleapp.business.model.CommonSection;
import djoleapp.business.model.Flat;
import djoleapp.business.model.Garage;
import djoleapp.business.model.IndependentSection;
import djoleapp.business.model.Occupant;
import djoleapp.business.model.ParkingBox;
import djoleapp.business.model.ParkingSpace;
import djoleapp.business.model.ResidentialCommunity;
import djoleapp.business.model.SeparateSection;
import djoleapp.controller.Controller;
import djoleapp.controller.constant.Constants;
import djoleapp.controller.util.Message;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author perica.simic
 */
public class FacadeSER implements Facade {

    @Override
    public boolean loginAdminCheck(String username, String password) {
        List<Administrator> list = Factory.getStorage().loadAdmin();
        for (Administrator a : list) {
            if (username.equals(a.getUsername()) && password.equals(a.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean chackExistOccupantBuilding(ResidentialCommunity r, Occupant o) {
        for (Occupant oc : r.getListOccupants()) {
            if (oc.getId() == o.getId()) {
                Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_BUILDING_EXIST);
                return false;
            }
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
    public double pricePerArea(SeparateSection section) {

        if (section instanceof ParkingBox) {
            return Constants.PARKING_BOX_PRICE;
        }
        if (section instanceof ParkingSpace) {
            return Constants.PARKING_SPACE_PRICE;
        }
        if (section instanceof Garage) {
            return Constants.GARAGE_PRICE;
        }
        if (section instanceof BusinessSpace) {
            return Constants.BUSINESS_PRICE;
        }
        if (section instanceof Flat) {
            return Constants.FLAT_PRICE;
        }
        return 0;
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

    @Override
    public boolean checkAddBuildingFieldsEmpty(String name, String idNum, String taxNum, String mail) {
        if (name.isEmpty() || name == null || idNum.isEmpty() || idNum == null || taxNum.isEmpty() || taxNum == null || mail.isEmpty() || mail == null) {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAddBuildingFieldExist(String name, String idNum, String taxNum, String mail) {

        for (ResidentialCommunity rc : Controller.getInstance().getTemporaryList().getResidentialCommunitys()) {
            if (rc.getName().replaceAll("\\s+", "").equalsIgnoreCase(name.replaceAll("\\s+", "")) || rc.getIdentificationNumber().replaceAll("\\s+", "").equalsIgnoreCase(idNum.replaceAll("\\s+", ""))
                    || rc.getTaxIdentificationNumber().replaceAll("\\s+", "").equalsIgnoreCase(taxNum.replaceAll("\\s+", "")) || rc.getMail().replaceAll("\\s+", "").equalsIgnoreCase(mail.replaceAll("\\s+", ""))) {
                Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_BUILDING_EXIST);
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean removeBuilding(ResidentialCommunity rc) {
        List<Occupant> occupants = new ArrayList<>();

        if (rc == null) {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_NOT_SELECT);
            return false;
        }

        if (!rc.getListOccupants().isEmpty()) {
            for (Occupant o : Controller.getInstance().getTemporaryList().getOccupants()) {
                List<ResidentialCommunity> tempResList = new ArrayList<>();
                for (ResidentialCommunity r : o.getResidentials()) {
                    if (r.getIdentificationNumber() != rc.getIdentificationNumber()) {
                        tempResList.add(r);
                    }
                }
                o.setResidentials(tempResList);
                occupants.add(o);
            }

        }

        Controller.getInstance().getTemporaryList().setOccupants(occupants);
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
        return true;

    }

    @Override
    public boolean addSeparateSection(boolean isAdd, ResidentialCommunity rc, String section, String number, String areaSection, String note, Occupant owner) {

        SeparateSection sep = Controller.getInstance().getTemporarySeparateSection();

        if (rc == null || section.isEmpty() || section == null || number.isEmpty() || number == null || areaSection == null || areaSection.isEmpty() || note.isEmpty() || note == null) {
            Message.info(Alert.AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.ALERT_EMPTY_INPUT_TEXT);
            return false;
        }

        double area = Double.valueOf(areaSection);

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
    public void addIndSection(String name, String note, Occupant owner, String price) {

        if (name == null || name.isEmpty()) {
            Message.info(AlertType.WARNING, Constants.ALERT_WARNING_DIALOG, Constants.HAVE_TO_NAME_INDEPENDENT);
            return;
        }
        IndependentSection ipSection = new IndependentSection(name);
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

}
