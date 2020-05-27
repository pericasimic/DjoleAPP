package djoleapp.business.model;

import java.io.Serializable;

public class BankAccount implements Serializable {

    private String bankName;
    private String bankAccountNumber;

    public BankAccount(String bankName, String bankAccountNumber) {
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
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

    @Override
    public String toString() {
        return bankName + ": " + bankAccountNumber;
    }

}
