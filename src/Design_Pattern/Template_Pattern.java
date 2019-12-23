package Design_Pattern;

public class Template_Pattern {
    public static void main(String[] args) {
        House house = new WoodenHouse();
        house.templateMethod();
    }
}
abstract class House
{
    abstract void header();
    abstract void body();
    //hook
    void footer()
    {
        System.out.println("Build with sand and steel");
    }

    //template method
    public final void templateMethod()
    {
        footer();
        body();
        header();
    }
}

class WoodenHouse extends House
{
    @Override
    protected void header() {
        System.out.println("Wooden header");
    }

    @Override
    protected void body() {
        System.out.println("Wooden Body");
    }
}
class ConcreteHouse extends House
{
    @Override
    void header() {
        System.out.println("Concrete roof");
    }

    @Override
    void body() {
        System.out.println("Concrete body");
    }
}