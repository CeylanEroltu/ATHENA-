public class InterfaceEx {
    public static void main(String[] args) {
        
        Phone myPhone = new Phone("Iphone");
        System.out.println("--- Phone ---");
        myPhone.play();  // Playing music on Samsung phone...
        myPhone.pause(); // Pausing music on Samsung phone.
        myPhone.stop();  // Stopping music on Samsung phone.
        System.out.println();

       
        Computer myComputer = new Computer("Laptop");
        System.out.println("--- Computer ---");
        myComputer.play();  
        myComputer.pause(); 
        myComputer.stop();  
    }
}


interface MusicPlayer {
    void play();
    void pause();
    void stop();
}


class Phone implements MusicPlayer {
    private String brand;

    public Phone(String brand) {
        this.brand = brand;
    }

    @Override
    
    public void play() {
        System.out.println("Playing music on " + brand + " phone");
    }

    @Override

    public void pause() {
        System.out.println("Pausing music on " + brand + " phone");
    }

    @Override

    public void stop() {
        System.out.println("Stopping music on " + brand + " phone");
    }
}

class Computer implements MusicPlayer {
    private String type;

    public Computer(String type) {
        this.type = type;
    }

    @Override

    public void play() {
        System.out.println("Playing playlist on " + type + " computer");
    }

    @Override

    public void pause() {
        System.out.println("Pausing playlist on " + type + " computer");
    }

    @Override

    public void stop() {
        System.out.println("Stopping playlist on " + type + " computer");
    }
}




