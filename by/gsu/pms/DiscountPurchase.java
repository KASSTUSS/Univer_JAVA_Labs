package by.gsu.pms;

public class DiscountPurchase extends Purchase {
    private double discount;

    public DiscountPurchase() {
        super();
    }

    public DiscountPurchase(String commodityName, double price, int numberOfUnits, double discount) {
        super(commodityName, price, numberOfUnits);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double getCost() {
        return (getPrice() - discount) * getNumberOfUnits();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}