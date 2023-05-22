package by.gsu.pms;

public class PercentDiscountPurchase extends AbstractPurchase {
    private double discountPercentage;

    public PercentDiscountPurchase() {
        super();
    }

    public PercentDiscountPurchase(Commodity commodity, int numberOfUnits, double discountPercentage) {
        super(commodity, numberOfUnits);
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getCost() {
        double cost = getCommodity().getPrice() * getNumberOfUnits();
        double discountAmount = cost * (discountPercentage / 100);
        return cost - discountAmount;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}