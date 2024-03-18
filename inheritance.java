public class inheritance {
    
    public static void main(String[] args) {

        Student s = new Student();
        s.setName("John Doe");

        Instructors i = new Instructors();
        i.setName("Jenny Smith");
        i.setNo(123);

        System.out.println(s.toString());
        System.out.println(i.toString());


        Car car = new Car();
        car.go();
        Bicycle bike = new Bicycle();
        bike.stop();

        System.out.println(car.doors);
        System.out.println(bike.pedals);


        Berries ber = new Berries();
        Cherries che = new Cherries();
        ber.grow(5);
        ber.die("my berry plant");
        che.grow(7);
        che.die("my cherry plant");

        Calisan c = new Calisan();
        Akademisyen a = new Akademisyen();
        Memurlar m = new Memurlar();
        System.out.println(Akademisyen.giris());
        System.out.println(Memurlar.giris());


    }

}

class Person {

    private String name = "Joe Due";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    @Override

    public String toString() {
        return "Person(" + "name" + name + ")";
    }
}

class Student extends Person {

}

class Instructors extends Person {

    private int no = 000;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override

    public String toString() {
        return "Person(" + "no" + no + ")";
    }
}

class Vehicle {

    double speed;

    public void go() {
        System.out.println("This vehicle is moving");
    }

    public void stop() {
        System.out.println("This vehicle is stopped");
    }
}

class Bicycle extends Vehicle {

    int wheels = 2;
    int pedals = 2;

}

class Car extends Vehicle {

    int wheels = 4;
    int doors = 4;
}

class Plant {
    
    public void grow (int rate) {
        System.out.println(rate + "cm per day");
    }

    public void die(String type) {
        System.out.println(type + "has died : ");
    }
}

class Berries extends Plant {

}

class Cherries extends Plant {
    
}


class Calisan {

    String adSoyad;
    String eposta;
    int telefon;
    static int girisSayisi = 0;

    public static int giris() {

        return ++Calisan.girisSayisi;
    }
}

class Akademisyen extends Calisan {

    String bolum;
    String gorevler;
    String[] dersler;

}

class Memurlar extends Calisan {

    String departman;
    String mesai;
}
