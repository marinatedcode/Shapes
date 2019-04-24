import java.util.Arrays;

/**
 * @author Marinated
 */
public class Shape {

    private Color color;
    private float length;

    public Shape() throws Exception {
        this(1.0f, "black");
    }

    public Shape(float length) throws Exception {
        this(length, "black");
    }

    public Shape(String color) throws Exception {
        this(1.0f, color);
    }

    public Shape(float l, String c) throws Exception {
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