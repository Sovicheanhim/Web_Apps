package Design_Pattern;

interface strategy{
    public int doOperation(int a, int b);
}
class doOperationAdd implements strategy{

    @Override
    public int doOperation(int a, int b) {
        return a+b;
    }
}

class  doOperationSubstract implements strategy{

    @Override
    public int doOperation(int a, int b) {
        return a-b;
    }
}
class doOperationMultiply implements strategy{

    @Override
    public int doOperation(int a, int b) {
        return a*b;
    }
}

class context{
    strategy strategy;
    public context(strategy strategy){
        this.strategy = strategy;
    }
    public int  executeOperation(int a, int b){
        return strategy.doOperation(a,b);
    }
}
public class Strategy_Pattern {
    public static void main(String[] args) {
        context context = new context(new doOperationAdd());
        System.out.println(String.format("10 + 20 = %s",context.executeOperation(10,20)));
        context = new context(new doOperationSubstract());
        System.out.println(String.format("20 - 10 = %s",context.executeOperation(20,10)));
    }
}
