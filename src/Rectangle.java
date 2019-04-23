public class Rectangle extends Shape
{
    private float width;
    public Rectangle() {
        super();
        this.width = getLength();
    }
    public Rectangle(float length) {
        this(length, length);
    }

    public Rectangle(float length, float width) {
        super();
        setLength(length);
        this.width = width;
    }

    public Rectangle(float length, float width, String color) {
        setLength(length);
        setColor(color);
        this.width = width;
    }

    public Rectangle(float l, String c) {
        this(l);
        setColor(c);
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getWidth() {
        return width;
    }

    public float getArea() {
        return getLength()*width;
    }

    public float getPerimeter() {
        return (2*getLength()) + (2*width);
    }

    @Override
    public String toString() {
        return "Length: " + getLength() + ", Width: " + getWidth() + ", Color: " + getColor();
    }
}
