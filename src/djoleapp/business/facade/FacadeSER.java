/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djoleapp.business.facade;

import djoleapp.business.Factory;
import djoleapp.business.model.Administrator;
import djoleapp.business.model.BankAccount;
import djoleapp.business.model.BusinessSpace;
import djoleapp.business.model.Flat;
import djoleapp.business.model.Garage;
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
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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

}
