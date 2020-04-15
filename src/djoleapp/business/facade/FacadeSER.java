/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djoleapp.business.facade;

import djoleapp.business.Factory;
import djoleapp.business.model.Administrator;
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
import java.util.ArrayList;
import java.util.List;

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

}
