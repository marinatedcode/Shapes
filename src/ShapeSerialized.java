import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Marinated
 */
class ShapeSerialized implements Serializable {

    private Color color;
    private float length;

    public ShapeSerialized() throws Exception {
        this(1.0f, "black");
    }

    public ShapeSerialized(float length) throws Exception {
        this(length, "black");
    }

    public ShapeSerialized(String color) throws Exception {
        this(1.0f, color);
    }

    public ShapeSerialized(float l, String c) throws Exception {
        setLength(l);
        setColor(c);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(String c) throws Exception {
        boolean found = false;
        for (Color col : Color.values()) {
            if (col.name().equalsIgnoreCase(c)) {
                this.color = col;
                found = true;
            }
        }
        if (!found) {
            throw new Exception("Error: " + c + " is not a valid color. Valid options are " + colors() + ".");
        }
    }

    public float getLength() {
        return length;
    }

    public void setLength(float l) throws Exception {
        if (l > 0.0) {
            this.length = l;
        } else {
            throw new Exception("Error: Length must be a floating point number greater than 0.0!");
        }
    }

    public String colors() {
        return Arrays.toString(Color.values());
    }

    @Override
    public String toString() {
        return "Length: " + length + ", Color: " + color;
    }

    public enum Color {
        white, black, blue, red, green
    }
}

class ShapeSerializedTest {
    public static void main(String[] args) {

        ShapeSerialized object = null;
        String filename = "";
        boolean success = false;

        while (!success) {
            try {
                object = new ShapeSerialized(1, "black");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the shape's length: ");
                object.setLength(scanner.nextFloat());
                scanner.nextLine();
                System.out.println("Enter the shape's color " + Arrays.toString(ShapeSerialized.Color.values()) + ": ");
                object.setColor(scanner.nextLine());
                filename = "file.ser";
                success = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Serialization - outputting object to a file
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Shape has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        ShapeSerialized object1 = null;

        // Deserialization - Creating an object from a file
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (ShapeSerialized) in.readObject();

            in.close();
            file.close();

            System.out.println("Shape has been deserialized ");
            System.out.println("Shape written to file - " + object1.toString());
            System.out.println("Shape read  from file - " + object1.toString());
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}

