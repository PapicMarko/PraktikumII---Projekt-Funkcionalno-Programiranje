package osnove;

public class DoubleInterfaceImpl implements MyInterface1, MyInterface2 {
    public DoubleInterfaceImpl() {
        System.out.println("hello from DoubleInterfaceImpl");
    }

    @Override
    public void methodOne() {
        System.out.println("method from interface");
        System.out.println(myInt);
    }

    @Override
    public void methodTwo() {
        System.out.println("method from second interface");
        System.out.println(myString);
    }
}