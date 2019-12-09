public class Singleton {
    public static void main(String[] args) {
        SingletonClass obj = SingletonClass.getInstance();
        obj.print();
    }
}
class SingletonClass {
    int id = 0;
    String name = "";
    private static SingletonClass instance = new SingletonClass();
    private SingletonClass(){}
    public static SingletonClass getInstance(){
        return instance;
    }
    public static void print(){
        System.out.println("Hello World");
    }
}