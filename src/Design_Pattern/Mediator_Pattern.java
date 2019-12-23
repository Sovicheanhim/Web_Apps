package Design_Pattern;

public class Mediator_Pattern {
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
    void setLandingStattus(Boolean status);
}
class Runway implements Command_Mediator
{
    private IATCMediator atcMediator;

    @Override
    public void land() {
        System.out.println("Landing permission granted");
        atcMediator.setLandingStattus(true);
    }
    public Runway(IATCMediator atcMdeiator) {
        this.atcMediator = atcMdeiator;
    }
}
class Flight implements Command_Mediator
{
    IATCMediator atcMediator;
    @Override
    public void land() {

    }
}
