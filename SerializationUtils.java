import exception.FileAccessException;

import java.io.*;

public class SerializationUtils {

    public static void serialize(Object object, String fileName) throws FileAccessException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(object);
            System.out.println("Object serialized and saved to file: " + fileName);
        } catch (IOException e) {
            throw new FileAccessException("Failed to serialize object: " + e.getMessage());
        }
    }

    public static Object deserialize(String fileName) throws FileAccessException {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object object = ois.readObject();
            System.out.println("Object deserialized from file: " + fileName);
            return object;
        } catch (IOException | ClassNotFoundException e) {
            throw new FileAccessException("Failed to deserialize object: " + e.getMessage());
        }
    }
}