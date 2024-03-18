public class EmployeeDriver {

    public static void main(String[] args) {

        Employee emp1 = new Employee(1985, 45, 2000, "Kemal");

        emp1.printEmployee();

    }
}
class Employee {

    private String name;
    private double salary;
    private int workHours, hireYear;

    Employee(int hireYear, int workHours, double salary, String name) {

        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax() {

        if(this.salary >= 1000) {
            return salary * 0.03;
        }
        return 0.0;
    }

    public double bonus() {

        int extraHours = this.workHours - 40;
         
        return 30 * extraHours;
    }

    public double increase() {

        int year = 2020 - this.hireYear;

        if (year < 10) {
            return salary * 0.5;
        }

        else if (year >= 10 && year < 20) {
            return salary * 0.10;
        }
        else {
            return salary * 0.15;
        }
    }


    public void printEmployee() {

        System.out.println("Tax : " + tax());
        System.out.println("Bonus : " + bonus());
        System.out.println("Increase Salary : " + increase());
        
        double totalSalary = salary - tax() + bonus();

        System.out.println("Total salary with tax and bonus: " + totalSalary);
        System.out.println("Total salary with the raise of salary: " + (salary + increase()));

    }


}

