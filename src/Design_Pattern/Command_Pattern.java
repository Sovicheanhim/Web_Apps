package Design_Pattern;

interface Command{
    public void execute();
}
class Light{
    public void on(){
        System.out.println("The light is on");
    }
    public void off(){
        System.out.println("The light is off");
    }

}

class commandLightOn implements Command{
    Light light;
    public commandLightOn(Light light){
        this.light = light;
    }
    public void execute(){
        light.on();
    }

}

class commandLightOff implements Command{

    Light light;
    public commandLightOff(Light light){
        this.light = light;
    }
    public void execute(){
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

class Command_Pattern{
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light();

        remote.setCommand(new commandLightOff(light));
        remote.buttonWasPressed();

        remote.setCommand(new commandLightOn(light));
        remote.buttonWasPressed();
    }
}