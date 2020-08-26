package djoleapp.business.model;

import java.io.Serializable;

public class BankingStatement implements Serializable{
    
    private long id;
    private String numberStatement;
    private String title;
    private ResidentialCommunity residentialCommunity;
    
}
