public class Circle extends ShapeSerialized {

    private float circumference;

    public Circle() throws Exception {
        super();
    }

    public Circle(float l, String c) throws Exception {
        setLength(l);
        setColor(c);
        //Sets the circumference
        getPerimeter();
    }

    /**
     * Gets the area of the circle
     * @return the double area
     */
    public double getArea() {
        return Math.PI * (getLength() * getLength());
    }

    /**
     * Gets the circumference of the circle
     * @return the double circumference
     */
    public float getPerimeter() {
        this.circumference =  (float) (2*Math.PI*getLength());
        return this.circumference;
    }

    @Override
    public String toString() {
        return "Radius: " + getLength() + ", Color: " + getColor();
    }
}

/*
4.  submit Circle.java - that inherits from Shape.java, where length
 is inherited as the 'radius' of the circle, add attribute
 'circumference'. Provide methods getArea() that calculates
 and returns the value of the circles area; getPerimeter()
 that calculates and returns the value of the circle's perimeter.
  Remember to provide constructors() for the new attributes.

 */