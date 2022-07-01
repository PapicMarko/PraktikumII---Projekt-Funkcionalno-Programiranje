package osnove;

import java.util.Objects;

public class Klasa {
    public enum NestedEnum {
        WORLD,
        HELLO,
    }
    public class NestedKlasa {
        public final int broj = 5;
    }
    public int broj;
    public String tekst;
    private boolean upit;

    public static float staticBroj;

    public final float finalBroj;


    public static void printBroj(){
        System.out.println(Klasa.staticBroj);
    }
    // Constructor
    public Klasa(int broj, String tekst) {

        System.out.println(tekst);
        System.out.println(broj);

        this.broj = broj;
        this.tekst= tekst;
        this.finalBroj = 0;
    }

    public Klasa(int broj, String tekst, boolean upit) {
        System.out.println(tekst);
        System.out.println(broj);
        System.out.println(upit);
        System.out.println();

        this.broj = broj;
        this.tekst= tekst;
        this.upit = upit;
        this.finalBroj = 0;
    }

    public Klasa(int broj, String tekst, boolean upit, float finalBroj) {
        System.out.println(tekst);
        System.out.println(broj);
        System.out.println(upit);
        System.out.println(finalBroj);
        System.out.println();

        this.broj = broj;
        this.tekst= tekst;
        this.upit = upit;
        this.finalBroj = finalBroj;
    }

    public void print(String text) {
        System.out.println("print string: "+text);
    }

    public void print(int num) {
        System.out.println("print int: "+num);
    }
    public int add(int num) {
        broj += num;
        return broj;
    }

    public int sub(int num) {
        broj -= num;
        return broj;
    }

    public boolean getUpit() {
        return upit;
    }

    public void setUpit(boolean upit) {
        this.upit = upit;
    }

    @Override
    public String toString() {
        return "Klasa{" +
                "broj=" + broj +
                ", tekst='" + tekst + '\'' +
                ", upit=" + upit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klasa klasa = (Klasa) o;
        return broj == klasa.broj && upit == klasa.upit && Objects.equals(tekst, klasa.tekst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(broj, tekst, upit);
    }

    public static Klasa clone(Klasa origin) {
        return new Klasa(origin.broj,origin.tekst,origin.upit,origin.finalBroj);
    }
}
