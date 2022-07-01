package osnove;

public class IntefaceImpl implements MyInterface1{
    public IntefaceImpl() {
        System.out.println(myInt);
    }

    @Override
    public void methodOne() {
        System.out.println("method from interface");
    }
}
