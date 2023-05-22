package by.gsu.pms;

public class Subject {
    private String name;
    private Material material;
    private double volume;

    public Subject() {
        // Default constructor
    }

    public Subject(String name, Material material, double volume) {
        this.name = name;
        this.material = material;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getMass() {
        System.out.println(material.getDensity() * volume);
        return material.getDensity() * volume;
    }

    @Override
    public String toString() {
        return name + "; " + material.toString() + "; " + volume + "; " + getMass();
    }
}