package by.gsu.pms;

public class Commodity {
    private String commodityName;
    private double price;

    public Commodity() {
        // Default constructor
    }

    public Commodity(String commodityName, double price) {
        this.commodityName = commodityName;
        this.price = price;
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

    @Override
    public String toString() {
        return commodityName + ";" + price;
    }
}