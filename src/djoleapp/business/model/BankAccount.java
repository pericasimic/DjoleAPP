package djoleapp.business.model;

public class BankAccount {
    
    private long id;
    private String bankName;
    private String bankAccountNumber;
    private boolean isExist;

    public BankAccount(long id, String bankName, String bankAccountNumber) {
        this.id = id;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.isExist = true;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public boolean isIsExist() {
        return isExist;
    }

    public void setIsExist(boolean isExist) {
        this.isExist = isExist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
}
