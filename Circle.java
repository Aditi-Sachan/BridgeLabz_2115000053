public class Circle {
    private double radius;

    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        Circle customCircle = new Circle(5.0);

        System.out.println("Default Circle Radius: " + defaultCircle.getRadius());
        System.out.println("Custom Circle Radius: " + customCircle.getRadius());
        System.out.println("Custom Circle Area: " + customCircle.calculateArea());
    }
}




