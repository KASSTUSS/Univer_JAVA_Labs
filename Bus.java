import java.util.ArrayList;
import java.util.List;

public class Bus implements Comparable<Bus> {
    private String driver;
    private String busNumber;
    private String routeNumber;
    private String brand;
    private int startYear;
    private int mileage;

    public Bus(String driver, String busNumber, String routeNumber, String brand, int startYear, int mileage) {
        this.driver = driver;
        this.busNumber = busNumber;
        this.routeNumber = routeNumber;
        this.brand = brand;
        this.startYear = startYear;
        this.mileage = mileage;
    }

    public String getDriver() {
        return driver;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public String getBrand() {
        return brand;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getMileage() {
        return mileage;
    }

    public String toString() {
        return "Bus: " + busNumber + ", Driver: " + driver + ", Route: " + routeNumber +
                ", Brand: " + brand + ", Start Year: " + startYear + ", Mileage: " + mileage;
    }

    @Override
    public int compareTo(Bus other) {
        return this.busNumber.compareTo(other.busNumber);
    }

    public static List<Bus> filterByRouteNumber(List<Bus> buses, String routeNumber) {
        List<Bus> result = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getRouteNumber().equals(routeNumber)) {
                result.add(bus);
            }
        }
        return result;
    }

    public static List<Bus> filterByOperatingYears(List<Bus> buses, int years) {
        List<Bus> result = new ArrayList<>();
        int currentYear = java.time.Year.now().getValue();
        for (Bus bus : buses) {
            if (currentYear - bus.getStartYear() > years) {
                result.add(bus);
            }
        }
        return result;
    }

    public static List<Bus> filterByMileage(List<Bus> buses, int mileage) {
        List<Bus> result = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getMileage() > mileage) {
                result.add(bus);
            }
        }
        return result;
    }
}