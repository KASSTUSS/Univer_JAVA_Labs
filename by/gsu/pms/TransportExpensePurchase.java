package by.gsu.pms;

public class TransportExpensePurchase extends AbstractPurchase {
    private double transportExpense;

    public TransportExpensePurchase() {
        super();
    }

    public TransportExpensePurchase(Commodity commodity, int numberOfUnits, double transportExpense) {
        super(commodity, numberOfUnits);
        this.transportExpense = transportExpense;
    }

    public double getTransportExpense() {
        return transportExpense;
    }

    public void setTransportExpense(double transportExpense) {
        this.transportExpense = transportExpense;
    }

    @Override
    public double getCost() {
        return (getCommodity().getPrice() * getNumberOfUnits()) + transportExpense;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}