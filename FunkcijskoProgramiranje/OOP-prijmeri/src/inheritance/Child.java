package inheritance;

public class Child extends Parent{
    public Child(int anInt, String text, float aFloat) {
        super(anInt, text, aFloat);
        System.out.println("child constructor");
        //this.text = "hello"; // error: 'text' has private access in 'inheritance.Parent'
    }

    @Override
    public void print() {
        System.out.println("in child method");
    }
    /*
    @Override
    public final void finalMethod(){
        System.out.println("in child final method");
    }*/ // <-- error: finalMethod() in inheritance.Child cannot override finalMethod() in inheritance.Parent overridden method is final

    public void printProtected(){
        System.out.println(this.aFloat);
    }
}
