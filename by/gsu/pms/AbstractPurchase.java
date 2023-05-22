package by.gsu.pms;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private Commodity commodity;
    private int numberOfUnits;

    public AbstractPurchase() {
        // Default constructor
    }

    public AbstractPurchase(Commodity commodity, int numberOfUnits) {
        this.commodity = commodity;
        this.numberOfUnits = numberOfUnits;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public abstract double getCost();

    @Override
    public String toString() {
        return commodity.toString() + ";" + numberOfUnits + ";" + getCost();
    }

    @Override
    public int compareTo(AbstractPurchase purchase) {
        return Double.compare(purchase.getCost(), this.getCost());
    }
}