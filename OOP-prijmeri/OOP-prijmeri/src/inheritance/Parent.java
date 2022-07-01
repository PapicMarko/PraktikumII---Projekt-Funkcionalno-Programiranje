package inheritance;

public class Parent {
    public int anInt;
    private String text;
    protected float aFloat;

    public Parent(int anInt, String text, float aFloat) {
        System.out.println("parent constructor");
        this.anInt = anInt;
        this.text = text;
        this.aFloat = aFloat;
    }
    public void inheritedMethod() {
        System.out.println("this method is from the parent class");
        System.out.println(this.anInt);
    }
    public final void finalMethod(){
        System.out.println("in parent final method");
    }

    public void print() {
        System.out.println("in parent method");
    }
}
