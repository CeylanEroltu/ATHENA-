public class polymorphism2 {
    public static void main(String[] args) {
        
        Television t;
        t = new DVDPlayerTelevision(10.5, 7, 9);
        t.channelTuning(2);

        t = new SoundBarTelevision(10.5, 7, 9);

    }
}
class Television {

    private double width;
    private double height;
    private double screenSize;
    private int maxVolume;
    private int volume;
    private int channel;
    private boolean power;

    public Television  (double width, double height, double screenSize) {
        this.width = width;
        this.height = height;
        this.screenSize = screenSize;
    }

    public double channelTuning(int channel) {
        System.out.println("Analog circular dial");
        switch(channel){
        case 1: return 34;
        case 2: return 54;
        case 3: return 73;
        case 4: return 95;
        }
        return 0;
    }

    public int decreaseVolume (){
        if(0 < volume) volume --;
        return volume;
    }

    public void powerSwitch(){
        this.power =! power;
    }

    public int increaseVolume(){
        if(maxVolume > volume) volume++;
        return volume;
    }
}

class DVDPlayerTelevision extends Television {

    public DVDPlayerTelevision (double width, double height, double screenSize) {
        super(width, height, screenSize);
    }

    @Override

    public double channelTuning(int channel) {
        System.out.println("Channel button");

        switch(channel) {

            case 1: return 34;
            case 2: return 54;
            case 3: return 73;
            case 4: return 95;
        }

        return 0;
    }

    public void playDVD() {
        System.out.println("Play DVD");
    }
}

class SoundBarTelevision extends Television {
    public SoundBarTelevision(double width, double height, double screenSize){
        super(width, height, screenSize);
    }

    @Override

    public double channelTuning(int channel) {
        System.out.println("Remote button");

        switch(channel){

            case 1: return 34;
            case 2: return 54;
            case 3: return 73;
            case 4: return 95;
        }

        return 0;
    }

    public void soundQuality() {
        System.out.println("Sound System");
    }
}