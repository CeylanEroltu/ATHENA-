public class CircleEx {
        public static void main(String[] args) {

            Circle circle = new Circle();
            circle.setRadius(6);
            circle.setColor("Green");
            System.out.println(circle.toString());
        }
    }

    // with using get - set
    
    class Circle {
        
        private int radius;
        private String color;
    
        public Circle() {
        }
    
        public int getRadius() {
            return radius;
        }
    
        public void setRadius(int radius) {
            this.radius = radius;
        }
    
        public String getColor() {
            return color;
        }
    
        public void setColor(String color) {
            this.color = color;
        }
    
        public double getArea() {
            return Math.PI * radius * radius;
        }
    
        @Override

        public String toString() {
            return "Circle: Radius = " + radius + ", Color = " + color + ", Area = " + getArea();
        }
    }
    
// without using get - set

 /*    public static void main(String[] args) {

        Circle circle = new Circle(4, "Blue");
        System.out.println(circle.toString());
    }
}
class Circle {
    private int radius;
    private String color;
    
    
    public Circle(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    
   
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
   
    public String toString() {
        return "Circle: Radius =" + radius + ", Color =" + color + ", Area =" + getArea();
    }
           */

