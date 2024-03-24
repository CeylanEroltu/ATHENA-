import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.*;

public class Lab05_20230808070 {
    public static void main (String[] args) {

        CPU cpu = new CPU("i7-13700k", 3.9);
        RAM ram = new RAM("DDR5", 32);

        Computer c = new Computer(cpu, ram);
        c.run();
        System.out.println(c);

        
        Laptop laptop = new Laptop(cpu, ram, 5000);
        laptop.run();
        System.out.println(laptop.batteryPercentage());
        System.out.println(laptop);

        
        Desktop desktop = new Desktop(cpu, ram, "Keyboard", "Mouse", "Monitor");
        desktop.run();
        desktop.plugIn("Printer");
        System.out.println(desktop.plugOut());
        System.out.println(desktop);

        
        ram.setValue(0, 0, 20);
        c.run();
        System.out.println(c);
        

    }
}

class Computer {

    private CPU cpu;
    private RAM ram;

    Computer (CPU cpu, RAM ram) {

        this.cpu = cpu;
        this.ram = ram;
    }
    public void run() {

        for(int i =0; i < ram.getCapacity(); i++){
            int value1 = ram.getValue(0 , 0);
            int value2 = ram.getValue(i, i);
            int result = -1;

            try {
                result = cpu.compute(value1, value2);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            ram.setValue(0, 0, result);
        }
     }

    public String toString() {
        return "Computer: " + cpu + " " + ram;
    }
}

class ComputationException extends RuntimeException{
    private CPU cpu;
    private int result;

    ComputationException(CPU cpu, int result) {
        this.cpu = cpu;
        this.result = result;
    }

    public CPU getCpu() {
        return cpu;
    }

    public int getResult() {
        return result;
    }
}


class CPU {
    private String name;
    private double clock;

    CPU(String name, double clock) {
        this.name = name;
        this.clock = clock;
    }

    public String getName(){
        return name;
    }

    public double getClock(){
        return clock;
    }

    public int compute(int a, int b) throws ComputationException {
        try {
            Thread.sleep((int)((4 / clock) * 1000));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        int result = a + b;
        if (result < 0)
            throw new ComputationException(this, result);

            System.out.println("Result: " + result);
            return result;
    }

    @Override
    public String toString(){
        return "CPU: " + name + " , " + clock + "G..";
    }
}

class RAM {

    private String type;
    private int capacity;
    private int [][] memory;

    RAM(String type, int capacity) {

        this.type = type;
        this.capacity = capacity;
        initMemory();
    }

    public void initMemory(){
        Random rnd = new Random();
        memory = new int[capacity][capacity];
        for(int i = 0; i < capacity; i++){
            for(int j = 0; j < capacity; i++) {
                memory[i][j] = rnd.nextInt(10);
            }
        }
    }

    public String getType(){
        return type;

}

    private boolean check(int i, int j) throws MemoryException {

        if(i < 0 || i >= capacity || j < 0 || j >= capacity)
        throw new MemoryException(this, i, j);

        return true;
    }
    public int getValue(int i, int j) throws MemoryException{
        check(i, j);
        return memory[i][j];
    }

    public void setValue(int i, int j, int value) throws MemoryException {
        check(i, j);
        memory[i][j] = value;
    }

}

class MemoryException extends RuntimeException {

    private RAM ram;

    MemoryException(RAM ram, int i, int j){
        super("indexes are out of the bounds of" +
        "the memory " + ram + "for indexes " + i + "and " + j);
        this.ram = ram;
    }
}

class Laptop extends Computer {

    int milliAmp;
    int battery;

    Laptop(CPU cpu, RAM ram, int milliAmp) {
        super(cpu, ram);
        this.milliAmp = milliAmp;
        this.battery = milliAmp * 30 / 100;
    }

    public int batteryPercentage() {
        return (battery * 100) / milliAmp;
    }

    public void charge() {
        while (batteryPercentage() < 90) {
            battery += milliAmp * 2 / 100;
        }
    }

    @Override
    public void run() {
        if (batteryPercentage() > 5) {
            super.run();
            battery -= milliAmp * 3 / 100;
        } else {
            charge();
        }
    }

    public String toString() {
        return super.toString() + " " + battery;
    }
}

class Desktop extends Computer {
    ArrayList<String> peripherals;

     Desktop(CPU cpu, RAM ram, String... peripherals) {
        super(cpu, ram);
        this.peripherals = new ArrayList<>(Arrays.asList(peripherals));
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < ram.capacity; i++) {
            for (int j = 0; j < ram.capacity; j++) {
                sum += ram.getValue(i, j);
            }
        }
        RAM.setValue(0, 0, cpu.compute(sum, sum));
    }

    public void plugIn(String peripheral) {
        peripherals.add(peripheral);
    }

    public String plugOut() {
        if (!peripherals.isEmpty()) {
            return peripherals.remove(peripherals.size() - 1);
        }
        return null;
    }

    public String plugOut(int index) {
        if (index >= 0 && index < peripherals.size()) {
            return peripherals.remove(index);
        }
        return null;
    }

    public String toString() {
        return super.toString() + " " + peripherals.toString();
    }
}

    
