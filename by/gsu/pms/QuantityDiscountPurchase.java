package by.gsu.pms;

public class QuantityDiscountPurchase extends Purchase {
    private static final int QUANTITY_THRESHOLD = 15;
    private static final double DISCOUNT_PERCENTAGE = 5.825;

    public QuantityDiscountPurchase() {
        super();
    }

    public QuantityDiscountPurchase(String commodityName, double price, int numberOfUnits) {
        super(commodityName, price, numberOfUnits);
    }

    public static double calculateDiscount(double price, int numberOfUnits) {
        if (numberOfUnits > QUANTITY_THRESHOLD) {
            return price * numberOfUnits * (1 - DISCOUNT_PERCENTAGE / 100);
        }
        return price * numberOfUnits;
    }

    @Override
    public double getCost() {
        return calculateDiscount(getPrice(), getNumberOfUnits());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}