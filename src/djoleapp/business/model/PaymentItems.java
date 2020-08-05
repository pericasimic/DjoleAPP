package djoleapp.business.model;

import djoleapp.business.Factory;
import djoleapp.controller.constant.Constants;

public class PaymentItems {

    private String item;
    private double pricePer;
    private double sum;

    public PaymentItems(SeparateSection section) {

//        pricePer = Factory.getFacade().pricePerArea(section);
//        sum = Factory.getFacade().supportSum(pricePer, section.getSurfaceArea());
//        item = Constants.PAYMENT_ITEM_STRING_I + pricePer + Constants.PAYMENT_ITEM_STRING_II;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPricePer() {
        return pricePer;
    }

    public void setPricePer(double pricePer) {
        this.pricePer = pricePer;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
    
    

}
