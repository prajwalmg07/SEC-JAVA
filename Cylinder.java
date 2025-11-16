class Cylinder {
    private double radius;
    private double height;
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }
}

public class Main {
    public static void main(String[] args) {
        Cylinder c = new Cylinder();
        c.setRadius(5.5);
        c.setHeight(10.2);
        System.out.println("Radius: " + c.getRadius());
        System.out.println("Height: " + c.getHeight());
        System.out.println("Volume: " + c.getVolume());
    }
}
