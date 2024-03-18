public class interfaceProject {
    public static void main(String[] args) {

        PartTime pt = new PartTime();
        pt.setName("Alice");

        FullTime ft = new FullTime();
        ft.setName("Mark");

        Instructor[] instructors = {pt, ft};

        for(int i = 0; i < instructors.length; i++){

            if(instructors[i] instanceof PartTime){
                PartTime partTime = (PartTime) instructors[i];
                System.out.println(partTime.howToPay());
                System.out.println(partTime.toString());
            
            }

            if(instructors[i] instanceof FullTime){
                FullTime fullTime = (FullTime) instructors[i];
                System.out.println(fullTime.howToPay());
                System.out.println(fullTime.toString());
            }
        }
    }
}

class Employee {

    private String name = "Alice";

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override

    public String toString(){
        return "Employee{" + "name =" + name + '}';
    }
}

abstract class Instructor extends Employee{

    public abstract String howToPay();

}

interface Payable{

    public static final double payRate = 0.20;

    public abstract String howToPay();
}

class FullTime extends Instructor{

    @Override
    public String howToPay(){
        return "Pay by monthly";
    }
}

class PartTime extends Instructor{

    @Override
    public String howToPay(){
        return "Pay by hourly";
    }
}


