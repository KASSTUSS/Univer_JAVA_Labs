import java.io.*;

public class SerializationUtils {

    public static void serialize(Object object, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(object);
            System.out.println("Object serialized and saved to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to serialize object: " + e.getMessage());
        }
    }

    public static Object deserialize(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object object = ois.readObject();
            System.out.println("Object deserialized from file: " + fileName);
            return object;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to deserialize object: " + e.getMessage());
            return null;
        }
    }
}