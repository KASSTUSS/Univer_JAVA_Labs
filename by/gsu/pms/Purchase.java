package by.gsu.pms;

public class Purchase {
    private String commodityName;
    private double price;
    private int numberOfUnits;

    public Purchase() {
        // Default constructor
    }

    public Purchase(String commodityName, double price, int numberOfUnits) {
        this.commodityName = commodityName;
        this.price = price;
        this.numberOfUnits = numberOfUnits;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public double getCost() {
        return price * numberOfUnits;
    }

    @Override
    public String toString() {
        return commodityName + ";" + price + ";" + numberOfUnits + ";" + getCost();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Purchase otherPurchase = (Purchase) obj;
        return commodityName.equals(otherPurchase.commodityName) && price == otherPurchase.price;
    }
}