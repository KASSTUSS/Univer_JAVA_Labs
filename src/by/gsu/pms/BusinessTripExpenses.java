package by.gsu.pms;

public class BusinessTripExpenses {
    private float dailyRate;
    private String employeeAccount;
    private float transportExpenses;
    private int numOfDays;

    public BusinessTripExpenses() {
        dailyRate = 2.5f;
        employeeAccount = "Anton Slutsky";
        transportExpenses = 5.0f;
        numOfDays = 5;
    }
    public BusinessTripExpenses(float dailyRate, String employeeAccount, float transportExpenses, int numOfDays) {
        this.dailyRate = dailyRate;
        this.employeeAccount = employeeAccount;
        this.transportExpenses = transportExpenses;
        this.numOfDays = numOfDays;
    }

    public String getEmployeeAccount(){
        return this.employeeAccount;
    }
    public void setEmployeeAccount(String account){
        this.employeeAccount = account;
    }

    public float getTransportExpenses(){
        return this.transportExpenses;
    }
    public void setTransportExpenses(float transport){
        this.transportExpenses = transport;
    }

    public int getNumOfDays(){
        return this.numOfDays;
    }
    public void setNumOfDays(int day){
        this.numOfDays = day;
    }

    public float getTotal(){
        return this.transportExpenses + this.dailyRate * this.numOfDays;
    }

    public void show(){
        System.out.printf("rate = %f \naccount = %s \ntransport = %f \ndays = %d \ntotal = %f", this.dailyRate, this.employeeAccount, this.transportExpenses, this.numOfDays, getTotal());
    }

    public String toString(){
        return this.dailyRate + ";" + this.employeeAccount + ";" + this.transportExpenses + ";" + this.numOfDays + ";" + getTotal();
    }
}
