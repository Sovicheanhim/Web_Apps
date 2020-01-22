package Design_Pattern;

public class Mediator_Pattern {
    public static void main(String[] args) {
        IATCMediator atcMediator = new ATCMediator();
        Flight sparrow101 = new Flight(atcMediator);
        Runway mainRunway = new Runway(atcMediator);
        atcMediator.registerFlight(sparrow101);
        atcMediator.registerRunway(mainRunway);
        sparrow101.getReady();
        mainRunway.land();
        sparrow101.land();
    }
}
class ATCMediator implements IATCMediator{
    private Flight flight;
    private Runway runway;
    public boolean land;

    public void registerRunway(Runway runway){
        this.runway = runway;
    }
    public void registerFlight(Flight flight){
        this.flight = flight;
    }
    public boolean isLandingOK(){
        return land;
    }
    public void setLandingStatus(boolean status){
        land = status;
    }
}
interface Command_Mediator
{
    void land();
}
interface IATCMediator
{
    void registerRunway(Runway runway);
    void registerFlight(Flight flight);
    boolean isLandingOK();
    void setLandingStatus(boolean status);
}
class Runway implements Command_Mediator
{
    private IATCMediator atcMediator;

    public Runway(IATCMediator atcMediator){
        this.atcMediator = atcMediator;
        atcMediator.setLandingStatus(true);
    }
    @Override
    public void land() {
        System.out.println("Landing permission granted");
        atcMediator.setLandingStatus(true);
    }
}
class Flight implements Command_Mediator
{
    IATCMediator atcMediator;
    @Override
    public void land() {
        if(atcMediator.isLandingOK()){
            System.out.println("Successfully landed.");
            atcMediator.setLandingStatus(true);
        }else{
            System.out.println("Waiting for landing");
        }
    }
    public void getReady(){
        System.out.println("Ready for landing");
    }
    public Flight(IATCMediator atcMediator){
        this.atcMediator = atcMediator;
    }
}
