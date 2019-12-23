package Design_Pattern;

public class Decorative_Pattern {
    public static void main(String[] args) {
        Car_Decorative tesla = new TeslaAutoPilot(new TeslaBlue(new SimpleTesla()));
        System.out.println(tesla.getCost());
        System.out.println(tesla.getDescription());
    }
}
interface Car_Decorative{
    int getCost();
    String getDescription();
}
class SimpleTesla implements Car_Decorative{
    @Override
    public int getCost() {
        return 3000;
    }

    @Override
    public String getDescription() {
        return "Simple Design_Pattern.Car";
    }
}
abstract class TeslaDecorator implements Car_Decorative{
    private Car_Decorative car;
    public TeslaDecorator(Car_Decorative car){
        this.car = car;
    }

    @Override
    public int getCost() {
        return car.getCost();
    }

    @Override
    public String getDescription() {
        return car.getDescription();
    }
}
class TeslaBlue extends TeslaDecorator{
    TeslaBlue(Car_Decorative car){
        super(car);
    }

    @Override
    public int getCost() {
        return super.getCost() + 2000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", add Color Blue";
    }
}
class TeslaAutoPilot extends TeslaDecorator{
    TeslaAutoPilot(Car_Decorative car){
        super(car);
    }

    @Override
    public int getCost() {
        return super.getCost() + 8000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", add AutoPilot";
    }
}