package djoleapp.business.model;

import djoleapp.business.Factory;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AccountCalculation implements Serializable {

    private ResidentialCommunity residentialCommunity;
    private Occupant occupant;
    private String month;
    private String calculationNumber;
    private Date dateOfDelivery;
    private Date paymentDeadline;
    private List<PaymentItems> itemses;
    private double debitCurentMonth;
    private double debitPreviousMonth;
    private double sum;
    private String note;
    private boolean isPaid = false;
    private boolean isExist = true;

    public AccountCalculation() {
    }

    public AccountCalculation(ResidentialCommunity residentialCommunity, Occupant occupant,
            String calculationNumber, Date dateOfDelivery, Date paymentDeadline,
            List<PaymentItems> itemses, double debitCurentMonth,
            double debitPreviousMonth, double sum) {
        this.residentialCommunity = residentialCommunity;
        this.occupant = occupant;
        this.calculationNumber = calculationNumber;
        this.dateOfDelivery = dateOfDelivery;
        this.paymentDeadline = paymentDeadline;
        this.itemses = itemses;
        this.debitCurentMonth = debitCurentMonth;
        this.debitPreviousMonth = debitPreviousMonth;
        this.sum = sum;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public ResidentialCommunity getResidentialCommunity() {
        return residentialCommunity;
    }

    public void setResidentialCommunity(ResidentialCommunity residentialCommunity) {
        this.residentialCommunity = residentialCommunity;
    }

    public Occupant getOccupant() {
        return occupant;
    }

    public void setOccupant(Occupant occupant) {
        this.occupant = occupant;
    }

    public void setCalculationNumber(String calculationNumber) {
        this.calculationNumber = calculationNumber;
    }

    public String getCalculationNumber() {
        return calculationNumber;
    }


    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public Date getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(Date paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }

    public double getDebitCurentMonth() {
        return debitCurentMonth;
    }

    public void setDebitCurentMonth(double debitCurentMonth) {
        this.debitCurentMonth = debitCurentMonth;
    }

    public double getDebitPreviousMonth() {
        return debitPreviousMonth;
    }

    public void setDebitPreviousMonth(double debitPreviousMonth) {
        this.debitPreviousMonth = debitPreviousMonth;
    }
    
    public String getPaid(){
        if(isPaid == true){
            return "Plaćeno";
        }else{
            return "Neuplaćen";
        }
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public boolean isIsExist() {
        return isExist;
    }

    public void setIsExist(boolean isExist) {
        this.isExist = isExist;
    }

    public List<PaymentItems> getItemses() {
        return itemses;
    }

    public void setItemses(List<PaymentItems> itemses) {
        this.itemses = itemses;
    }

}
