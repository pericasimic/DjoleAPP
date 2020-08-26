package djoleapp.business.model;

import djoleapp.business.Factory;
import djoleapp.controller.constant.Constants;
import java.io.Serializable;

public class PaymentItems implements Serializable{

    private String item;
    private double sum;

    public PaymentItems(SeparateSection section) {
        double price = Factory.getFacade().pricePerArea(section);
        item = Constants.PAYMENT_ITEM_STRING_I + price + Constants.PAYMENT_ITEM_STRING_II;
        sum = Factory.getFacade().supportSum(price, section.getSurfaceArea());

    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

}
