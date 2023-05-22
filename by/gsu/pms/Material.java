package by.gsu.pms;

public class Material {
    private String name;
    private double density;

    public Material() {
        // Default constructor
    }

    public Material(String name, double density) {
        this.name = name;
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return name + ";" + density;
    }
}