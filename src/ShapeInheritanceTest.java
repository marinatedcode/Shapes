import java.util.Arrays;
import java.util.Scanner;

public class ShapeInheritanceTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        while (!success) {
            try {
                Circle circle1 = new Circle();
                Circle circle2 = new Circle(5.0f, "green");
                Rectangle rec1 = new Rectangle();
                Rectangle rec2 = new Rectangle(5.0f, 6.2f, "blue");
                System.out.println("Enter the circle's radius: ");
                circle1.setLength(scanner.nextFloat());
                scanner.nextLine();
                System.out.println("Enter the circle's color " + Arrays.toString(ShapeSerialized.Color.values()) + ": ");
                circle1.setColor(scanner.nextLine());
                System.out.println("Enter the rectangle's length: ");
                rec1.setLength(scanner.nextFloat());
                System.out.println("Enter the rectangle's width: ");
                rec1.setWidth(scanner.nextFloat());
                System.out.println(circle1.toString() + ", Area: " + circle1.getArea() + ", Circumference: " + circle1.getPerimeter());
                System.out.println(circle2.toString() + ", Area: " + circle2.getArea() + ", Circumference: " + circle2.getPerimeter());
                System.out.println(rec1.toString() + ", Area: " + rec1.getArea() + ", Perimeter: " + rec1.getPerimeter());
                System.out.println(rec2.toString() + ", Area: " + rec2.getArea() + ", Perimeter: " + rec2.getPerimeter());
                success = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
