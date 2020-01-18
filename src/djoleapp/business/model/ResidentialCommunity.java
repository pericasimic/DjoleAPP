package djoleapp.business.model;

import java.util.List;

public class ResidentialCommunity {
    
    private long id;
    private String name;
    private String identificationNumber;
    private String taxIdentificationNumber;
    private List<Occupant> listOccupants;
    private List<BankAccount> bankAccounts;
    private List<BusinessSpace> listBusSpace;
    private List<Flat> listFlats;
    private List<Garage> listGarages;
    private List<ParkingBox> listParkBox;
    private List<ParkingSpace> listParkSpace;
      
}
