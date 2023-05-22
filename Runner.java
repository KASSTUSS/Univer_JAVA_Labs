import by.gsu.pms.Material;
import by.gsu.pms.Subject;

public class Runner {
    public static void main(String[] args) {
        // Create the object representing the steel cube with volume 0.025 cubic meters
        Material steel = new Material("steel", 7850);
        Subject cube = new Subject("cube", steel, 0.025);

        // Print the object content
        System.out.println(cube.toString());

        // Update the cube material to copper
        Material copper = new Material("copper", 8500);
        cube.setMaterial(copper);

        // Print the cube mass
        System.out.println("Subject mass: " + cube.getMass());

        // Restore the cube material to steel
        cube.setMaterial(steel);

        // Print the cube material
        System.out.println(cube.toString());
    }
}