import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Lab03_20230808070 {

    public static void main(String[] args) {

        Vehicle car = new Car("BMW","M4", 2024, false, 8, true);

        Truck truck = new Truck("Mercedes", "A3", 2004, false, 8, false);

        Motorcycle motorcycle = new Motorcycle("Kawasaki", "S5", 2009, false, 5, true);

        Vehicle[] parkinglot = new Vehicle[] {car, truck, motorcycle};
        for(Vehicle vehicle : parkinglot) {
            vehicle.run();
        }

    }
}

class Vehicle {

    private String brand;
    private String model;
    private int year;
    private boolean IsRented;

     Vehicle (String brand, String model, int year, boolean IsRented) {

        setBrand(brand);
        setModel(model);
        setYear(year);
        setIsRented(IsRented);
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public boolean getIsRented(){
        return IsRented;
    }
    public void setIsRented(boolean IsRented) {
        this.IsRented = IsRented;
    }

     public void run(){

     }

    
}

class Car extends Vehicle {

    private int passengerCapacity;
    private boolean automaticTransmission;

    Car(String brand, String model, int year, boolean IsRented, int passengerCapacity, boolean automaticTransmission) {

        super(brand, model, year, IsRented);
        setPassengerCapacity(passengerCapacity);
        setAutomaticTransmission(automaticTransmission);

    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public void setPassengerCapacity(int passengerCapacity){
        this.passengerCapacity = passengerCapacity;
    }
    public boolean getAutomaticTransmission(){
        return automaticTransmission;
    }
    public void setAutomaticTransmission(boolean automaticTransmission){
        this.automaticTransmission = automaticTransmission;
    }

    @Override
    public void run() {
        System.out.println("Car is running...");
    }


 
    }



class Truck extends Vehicle  {

    private int loadCapacity;
    private boolean fourWheelDrive;

    Truck (String brand, String model, int year, boolean IsRented, int loadCapacity, boolean fourWheelDrive) {

        super(brand, model, year, IsRented);
        setLoadCapacity(loadCapacity);
        setFourWheelDrive(fourWheelDrive);


    }

    public int getLoadCapacity(){
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public boolean getFourWheelDrive(){
        return fourWheelDrive;
    }
    public void setFourWheelDrive(boolean fourWheelDrive){
        this.fourWheelDrive = fourWheelDrive;
    }

     @Override
    public void run() {
        
        System.out.println("Truck is running...");
    }


}

class Motorcycle extends Vehicle {

    private int engineVolume;
    private boolean hasABS;

    Motorcycle(String brand, String model, int year, boolean IsRented, int engineVolume, boolean hasABS) {

        super(brand, model, year, IsRented);
        setEngineVolume(engineVolume);
        setHasABS(hasABS);
        
    }

    public int getEngineVolume(){
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume){
        this.engineVolume = engineVolume;
    }

    public boolean getHasABS(){
        return hasABS;
    }
    public void setHasABS(boolean hasABS){
        this.hasABS = hasABS;
    }

    @Override
    public void run() {
        
        System.out.println("Motorcycle is running...");
    }

}

class Customer {

    private String firstName;
    private String lastName;
    private int idNumber;
    private ArrayList<Vehicle> rentedVehicles;
    private ArrayList<RentalContrat> rentalContrats;

 //   Vehicle[] rentedVehicles;
 //   ArrayList<RentalContrat> rentalContrats;


    Customer(String firstName, String lastName, int idNumber) {

        setFirstName(firstName);
        setLastName(lastName);
        setIdNumber(idNumber);
        this.idNumber = generateIdNumber();

    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    private int generateIdNumber() {
        Random rnd = new Random();
        return rnd.nextInt(1000);
    }

    public RentalContrat rent(Vehicle v, Date start, Date end) {
        RentalContrat contrat = new RentalContrat(this, v, start, end);
        rentalContrats.add(contrat);
        rentedVehicles.add(v);
        return contrat;


    }

}

class RentalContrat {

    private Customer customer;
    private Vehicle vehicle;
    private Date startDate;
    private Date endDate;

    RentalContrat (Customer customer, Vehicle vehicle, Date startDate, Date endDate) {

        setCustomer(customer);
        setVehicle(vehicle);
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
