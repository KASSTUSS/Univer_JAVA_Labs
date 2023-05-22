package by.gsu.pms;

public class DiscountPurchase extends AbstractPurchase {
    private double discount;

    public DiscountPurchase() {
        super();
    }

    public DiscountPurchase(Commodity commodity, int numberOfUnits, double discount) {
        super(commodity, numberOfUnits);
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
        return (getCommodity().getPrice() - discount) * getNumberOfUnits();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}