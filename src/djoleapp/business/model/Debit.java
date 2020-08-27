package djoleapp.business.model;

import java.io.Serializable;

public class Debit implements Serializable{
    
    private ResidentialCommunity residentialCommunity;
    private double debit = 0;

    public Debit(ResidentialCommunity residentialCommunity, double debit) {
        this.residentialCommunity = residentialCommunity;
        this.debit = debit;
    }

    public ResidentialCommunity getResidentialCommunity() {
        return residentialCommunity;
    }

    public void setResidentialCommunity(ResidentialCommunity residentialCommunity) {
        this.residentialCommunity = residentialCommunity;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }
    
    
    
}
