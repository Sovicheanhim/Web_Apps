public class Adapter_Pattern {
    public static void main(String[] args) {

    }
}
interface Hello{
    void hello();
}
interface Bye{
    void bye();
}
class Hi{
    void hi(){
        System.out.println("Hi");
    }
}
class Thank extends Hi implements Hello, Bye{
    public void hello() {
        System.out.println("Hello world");
    }

    @Override
    public void bye() {

    }
}