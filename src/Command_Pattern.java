interface Command{
    void execute();
}
class Light{
    public void on(){
        System.out.println("Light is on");
    }
    public void off(){
        System.out.println("Light is off");
    }
}
class LightOnCommand implements Command{
    Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    public void execute()
    {
        light.on();
    }
}
class LightOffCommand implements Command
{
    Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }
    public void execute()
    {
        light.off();
    }
}
class SimpleRemoteControl{
    Command command;
    public void setCommand(Command command){
        this.command = command;
    }
    public void buttonWasPressed(){
        command.execute();
    }
}
public class Command_Pattern {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();
        remote.setCommand(new LightOnCommand(light));
        remote.buttonWasPressed();
        remote.setCommand(new LightOffCommand(light));
        remote.buttonWasPressed();
    }
}