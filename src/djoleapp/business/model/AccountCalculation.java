package djoleapp.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountCalculation implements Serializable {
    
    private long id;
    private ResidentialCommunity residentialCommunity;
    private SeparateSection separateSection;
    private String title;
    private String titleNumber;
    private Date dateOfDelivery;
    private Date paymentDeadline;
    private String accountRecipient;
    private List<PurposeOfPayment> listPurposes = new ArrayList<>();
    private double debitCurentMonth;
    private double previousMonth;
    private double sum;
    private boolean isPaid = false;
    private boolean isExist = true;

    public AccountCalculation(long id) {
        this.id = id;
    }

    public AccountCalculation(long id, ResidentialCommunity residentialCommunity, SeparateSection separateSection, String title, String titleNumber, Date dateOfDelivery, Date paymentDeadline, String accountRecipient, double debitCurentMonth, double previousMonth, double sum) {
        this.id = id;
        this.residentialCommunity = residentialCommunity;
        this.separateSection = separateSection;
        this.title = title;
        this.titleNumber = titleNumber;
        this.dateOfDelivery = dateOfDelivery;
        this.paymentDeadline = paymentDeadline;
        this.accountRecipient = accountRecipient;
        this.debitCurentMonth = debitCurentMonth;
        this.previousMonth = previousMonth;
        this.sum = sum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ResidentialCommunity getResidentialCommunity() {
        return residentialCommunity;
    }

    public void setResidentialCommunity(ResidentialCommunity residentialCommunity) {
        this.residentialCommunity = residentialCommunity;
    }

    public SeparateSection getSeparateSection() {
        return separateSection;
    }

    public void setSeparateSection(SeparateSection separateSection) {
        this.separateSection = separateSection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleNumber() {
        return titleNumber;
    }

    public void setTitleNumber(String titleNumber) {
        this.titleNumber = titleNumber;
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

    public String getAccountRecipient() {
        return accountRecipient;
    }

    public void setAccountRecipient(String accountRecipient) {
        this.accountRecipient = accountRecipient;
    }

    public List<PurposeOfPayment> getListPurposes() {
        return listPurposes;
    }

    public void setListPurposes(List<PurposeOfPayment> listPurposes) {
        this.listPurposes = listPurposes;
    }

    public double getDebitCurentMonth() {
        return debitCurentMonth;
    }

    public void setDebitCurentMonth(double debitCurentMonth) {
        this.debitCurentMonth = debitCurentMonth;
    }

    public double getPreviousMonth() {
        return previousMonth;
    }

    public void setPreviousMonth(double previousMonth) {
        this.previousMonth = previousMonth;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public boolean isIsExist() {
        return isExist;
    }

    public void setIsExist(boolean isExist) {
        this.isExist = isExist;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
    
    
    
}
