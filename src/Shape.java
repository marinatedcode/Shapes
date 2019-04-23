import java.util.Arrays;

public class Shape {

    private Color color;
    private float length;

    public Shape() {
        this(1.0f, "black");
    }

    public Shape(float l, String c) {
        setLength(l);
        setColor(c);

    }

    public Color getColor() {
        return color;
    }

    public void setColor(String c) {
        boolean found = false;
        for (Color col : Color.values()) {
            if (col.name().equalsIgnoreCase(c)) {
                this.color = col;
                found = true;
            }
        }
        if (!found) {
            System.out.println("Error: " + c + " is not a valid color. Valid options are " + colors() + ".");
        }
    }

    public float getLength() {
        return length;
    }

    public void setLength(float l) {
        if (l > 0.0) {
            this.length = l;
        } else {
            System.out.println("Error: Length must be a floating point number greater than 0.0!");
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