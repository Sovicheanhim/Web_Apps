import java.util.Scanner;

public class Factory_Design_Pattern {
    public static void main(String[] args) {
        String car;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the car you want:");
        car = s.nextLine();

        Cars c = CarFactory.getCar(car);
        c.printInfo();
    }
}

class CarFactory{
    public static Cars getCar(String car){
        if(car.equals("audi")){
            return new Audi();
        }
        else if(car.equals("tesla")){
            return new Tesla();
        }
        else if(car.equals("cybertruck")){
            return new CyberTruck();
        }
        else{
            return null;
        }
    }
}

class Audi implements Cars{
    public void printInfo(){
        System.out.println("Audi");
    }
}

class Tesla implements Cars{
    public void printInfo(){
        System.out.println("Tesla...");
    }
}

class CyberTruck implements Cars{
    public void printInfo(){
        System.out.println("Cyber Truck...");
    }
}

interface Cars{
    void printInfo();
}