import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BusApp {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        List<Bus> buses = readBusesFromFile(inputFile);

        if (!buses.isEmpty()) {
            // Sort the buses based on bus number
            Collections.sort(buses);

            // Write the sorted result to the output file
            writeBusesToFile(buses, outputFile);

            // Example usage of filtering methods
            List<Bus> filteredByRoute = Bus.filterByRouteNumber(buses, "123");
            List<Bus> filteredByYears = Bus.filterByOperatingYears(buses, 5);
            List<Bus> filteredByMileage = Bus.filterByMileage(buses, 50000);

            // Display the filtered results
            System.out.println("Buses filtered by route number (123):");
            for (Bus bus : filteredByRoute) {
                System.out.println(bus);
            }

            System.out.println("Buses filtered by operating years (>5 years):");
            for (Bus bus : filteredByYears) {
                System.out.println(bus);
            }

            System.out.println("Buses filtered by mileage (>50000):");
            for (Bus bus : filteredByMileage) {
                System.out.println(bus);
            }
        }
    }

    private static List<Bus> readBusesFromFile(String fileName) {
        List<Bus> buses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (tokens.length == 6) {
                    String driver = tokens[0];
                    String busNumber = tokens[1];
                    String routeNumber = tokens[2];
                    String brand = tokens[3];
                    int startYear = Integer.parseInt(tokens[4]);
                    int mileage = Integer.parseInt(tokens[5]);
                    Bus bus = new Bus(driver, busNumber, routeNumber, brand, startYear, mileage);
                    buses.add(bus);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read from file: " + e.getMessage());
        }
        return buses;
    }

    private static void writeBusesToFile(List<Bus> buses, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Bus bus : buses) {
                writer.write(bus.toString());
                writer.newLine();
            }
            System.out.println("Sorted buses written to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to write to file: " + e.getMessage());
        }
    }
}