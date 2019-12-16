import com.sun.org.apache.xpath.internal.operations.And;

interface Earphone{
    void listen();
}
interface Airpod{
    void listen();
}
class Android implements Earphone{
    @Override
    public void listen() {
        System.out.println("Listening on Android device");
    }
}
class Earphone_connector implements Earphone
{
    private Iphone iphone;
    public Earphone_connector(Iphone iphone){
            this.iphone = iphone;
    }

    @Override
    public void listen() {
        iphone.listen();
    }
}
class Iphone implements Airpod{
    @Override
    public void listen() {
        System.out.println("Listening on Iphone device");
    }
}
public class Adapter_Pattern {
    public static void main(String[] args) {
        Android S10 = new Android();
        S10.listen();

        Iphone iphone7 = new Iphone();
        iphone7.listen();

        Earphone iphoneX = new Earphone_connector(new Iphone());
        iphoneX.listen();
    }
}