
public class polymorphism {
    public static void main(String[] args) {

        Student student = new Student("Jane" , 145);

     //   student.setGpa(4.0);    

        Undergraduate ug = new Undergraduate("Jack" , 230 , "Computer Science");
        
    //    ug.setGpa(3);

        Graduate grad = new Graduate("machine learning");


    //    System.out.println(student.toString());
    //    System.out.println(ug.toString());
    //    System.out.println(grad.toString());

    displayStudent(student);
    displayStudent(ug);
    displayStudent(grad);

    }

    public static void displayStudent (Student student) {
        System.out.println(student.toString());
    }

    public static void displayStudent (Undergraduate ug) {
        System.out.println(ug.toString());
    }

    public static void displayStudent (Graduate grad) {
        System.out.println(grad.toString());
    }


        Car car = new Car();
        Bicycle bicycle = new Bicycle();
        Boat boat = new Boat();

        Vehicle[] racers = {car, bicycle, boat};

        for (Vehicle x : racers) {
            x.go();
        }
    
}

class Student {

    private String name;
    private int code;

    public Student() {
    }

    public Student(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override

    public String toString() {
        return "Student{" + "name = " + name + "code = " + code + '}';
    }


}

class Undergraduate extends Student {

    private String major;

    public Undergraduate() {

    }

    public Undergraduate (String major) {

        this.major = major;
    }

    public Undergraduate  (String name, int code) {
        super(name, code);
    }

    public Undergraduate (String name, int code, String major) {
        super(name, code);
        this.major = major;
    } 

    @Override

    public String toString() {
        return super.toString() + "Undergraduate{" + "major = " + major + '}';
        
    }
}



class Graduate extends Student {

    private String thesis;

    public Graduate(){

    }

    public Graduate (String thesis) {
        this.thesis = thesis;

    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    @Override

    public String toString() {
        return super.toString() + "Graduate{" + "thesis" + thesis +'}';
    }
    }

class Vehicle {

    public void go(){

    }

}

class Car extends Vehicle {

    public void go() {
        System.out.println("The car begins moving");
    }

}

class Boat extends Vehicle {

    public void go() {
        System.out.println("The boat begins moving");
    }
}

class Bicycle extends Vehicle {

    public void go() {
        System.out.println("The bicycle begins moving");
    }

}
}