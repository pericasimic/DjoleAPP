package djoleapp.business.model;

public class PurposeOfPayment {
    
    private long id;
    private String titlePurpose;
    private double amount;

    public PurposeOfPayment(long id) {
        this.id = id;
    }

    public PurposeOfPayment(long id, String titlePurpose, double amount) {
        this.id = id;
        this.titlePurpose = titlePurpose;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitlePurpose() {
        return titlePurpose;
    }

    public void setTitlePurpose(String titlePurpose) {
        this.titlePurpose = titlePurpose;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    
}
