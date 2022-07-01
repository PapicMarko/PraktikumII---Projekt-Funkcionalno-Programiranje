import inheritance.Child;
import inheritance.GrandChild;
import osnove.*;
import inheritance.Parent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        {
            System.out.println("\nprimjer 1: Constructor\n");
            new Klasa(5,"Hello world!");
            new Klasa(7,"World hello!",true);
        }
        {
            System.out.println("\nprimjer 2: attributes\n");
            Klasa klasa = new Klasa(23,"Hello!");
            klasa.broj = 4;
            klasa.tekst = "World!";
            System.out.println(klasa.tekst);
            System.out.println(klasa.broj);
        }
        {
            System.out.println("\nprimjer 3: methods\n");
            Klasa klasa = new Klasa(55,"Hello World");
            klasa.add(5);
            System.out.println(klasa.broj);
            klasa.sub(2);
            System.out.println(klasa.broj);
        }
        {
            System.out.println("\nprimjer 4: private vs public\n");
            Klasa klasa = new Klasa(8,"Hello World!",true);
            System.out.println(klasa.broj); // <-- no error
            //System.out.println(klasa.upit); // <-- error: upit has private access in osnove.Klasa
        }
        {
            System.out.println("\nprimjer 5: getter\n");
            Klasa klasa = new Klasa(77,"Hello World!",false);
            boolean upit = klasa.getUpit();
            System.out.println(upit);
        }
        {
            System.out.println("\nprimjer 6: setter\n");
            Klasa klasa = new Klasa(87,"Hello World!",false);
            klasa.setUpit(true);
            System.out.println(klasa.getUpit());
        }
        {
            System.out.println("\nprimjer 7: toString\n");
            Klasa klasa = new Klasa(99,"Hello World!",true);
            System.out.println(klasa);
            System.out.println(klasa.toString());
        }
        {
            System.out.println("\nprimjer 8: equals\n");
            Klasa klasa1 = new Klasa(1,"Hello World!",true);
            Klasa klasa2 = new Klasa(1,"Hello World!",true);
            System.out.println(klasa1 == klasa2);
            System.out.println(klasa1.equals(klasa2));
        }
        {
            System.out.println("\nprimjer 9: hashCode\n");
            Klasa klasa1 = new Klasa(1,"Hello World!",true);
            Klasa klasa2 = new Klasa(2,"Hello World!",true);
            System.out.println(klasa1.hashCode());
            System.out.println(klasa2.hashCode());
        }
        {
            System.out.println("\nprimjer 10: static attributes\n");
            Klasa klasa = new Klasa(16,"Hello World!",true);
            klasa.staticBroj = 23; // works in java, may not in other oop languages
            System.out.println(Klasa.staticBroj);
            Klasa.staticBroj = 69;
            System.out.println(Klasa.staticBroj);
        }
        {
            System.out.println("\nprimjer 11: final attribute\n");
            Klasa klasa = new Klasa(16,"Hello World!",true, 123);
            System.out.println(klasa.finalBroj);
            //klasa.finalBroj = 23; // <-- error: final attribute can't be modified
        }
        {
            System.out.println("\nprimjer 12: static method\n");
            Klasa klasa = new Klasa(16,"Hello World!",true);
        }
        {
            System.out.println("\nprimjer 13: reference\n");
            Klasa klasa1 = new Klasa(16,"Hello World!",true);
            Klasa klasa2 = klasa1;
            System.out.println(klasa1.broj);
            klasa1.broj += 5;
            System.out.println(klasa2.broj);
            Klasa klasa3 = new Klasa(512,"Hello!",false);
            klasa1 = klasa3;
            System.out.println(klasa1.broj);
            System.out.println(klasa2.broj);
            System.out.println(klasa3.broj);
        }
        {
            System.out.println("\nprimjer 14: clone\n");
            Klasa klasa1 = new Klasa(16,"Hello World!",true);
            Klasa klasa2 = klasa1;
            System.out.println(klasa1.broj);
            klasa1.broj += 5;
            System.out.println(klasa2.broj);
            Klasa klasa3 = Klasa.clone(klasa1);
            klasa3.broj += 20;
            System.out.println(klasa1.broj);
            System.out.println(klasa2.broj);
            System.out.println(klasa3.broj);
        }
        {
            System.out.println("\nprimjer 15:  inheritance\n");
            Parent parent = new Parent(12,"test",5.5f);
            Child child = new Child(12,"test",5.5f);
        }
        {
            System.out.println("\nprimjer 16: multi-level inheritance\n");
            Parent parent = new Parent(12,"test",5.5f);
            Child child = new Child(12,"test",5.5f);
            GrandChild grandChild = new GrandChild(12,"test",5.5f);
        }
        {
            System.out.println("\nprimjer 17: inheritance public\n");
            Child child = new Child(12,"test",5.5f);
            System.out.println(child.anInt);
            child.anInt = 3;
            System.out.println(child.anInt);
        }
        {
            System.out.println("\nprimjer 18: inheritance private\n");
            Child child = new Child(12,"test",5.5f);
            //System.out.println(child.text); // <-- error: text has private access in inheritance.Parent
        }
        {
            System.out.println("\nprimjer 19: inheritance protected\n");
            Child child = new Child(12,"test",5.5f);
            child.printProtected();
            //System.out.println(child.aFloat); // <-- error: aFloat has protected access in inheritance.Parent
        }
        {
            System.out.println("\nprimjer 20: method inheritance\n");
            Parent parent = new Parent(12,"test",5.5f);
            Child child = new Child(21,"test",5.5f);
            parent.inheritedMethod();
            child.inheritedMethod();
        }
        {
            System.out.println("\nprimjer 21: method overriding\n");
            Parent parent = new Parent(12,"test",5.5f);
            Child child = new Child(21,"test",5.5f);
            parent.print();
            child.print();
        }
        {
            System.out.println("primjer 22: method overloading");
            Klasa klasa = new Klasa(16,"Hello World!",true);
            klasa.print("hello");
            klasa.print(56);
        }
        {
            System.out.println("\nprimjer 23: final method\n");
            Parent parent = new Parent(12,"test",5.5f);
            Child child = new Child(12,"test",5.5f);
            parent.finalMethod();
            child.finalMethod();
        }
        {
            System.out.println("\nprimjer 24: final class\n");
            // class inheritedFinal extends FinalKlasa {} // error: cannot inherit from final osnove.FinalKlasa
        }
        {
            System.out.println("\nprimjer 25: interface\n");
            IntefaceImpl inteface = new IntefaceImpl();
            inteface.methodOne();
        }
        {
            System.out.println("\nprimjer 26: multi interface\n");
            DoubleInterfaceImpl inteface = new DoubleInterfaceImpl();
            inteface.methodOne();
            inteface.methodTwo();
        }
        {
            System.out.println("\nprimjer 27: polymorphism\n");
            Parent parent = new Parent(2,"tekst",55.2f);
            Parent child = new Child(3,"test",12.4f);
            Parent grandchild = new GrandChild(99,"Hello world",42);
            parent.print();
            child.print();
            grandchild.print();
        }
        {
            System.out.println("\nprimjer 28: nested class\n");
            Klasa klasa = new Klasa(2,"test");
            Klasa.NestedKlasa nestedKlasa = klasa.new NestedKlasa();
            System.out.println(nestedKlasa.broj);
        }
        {
            System.out.println("\nprimjer 29: abstract class\n");
            //AbstractKlasa klasa = new AbstractKlasa(); // error: osnove.AbstractKlasa is abstract; cannot be instantiated
            AbstractKlasaImpl klasa = new AbstractKlasaImpl();
            klasa.abstractPrint();
            klasa.regularPrint();
        }
        {
            System.out.println("\nprimjer 30: abstract class w polymorphism\n");
            AbstractKlasa klasa = new AbstractKlasaImpl();
            klasa.abstractPrint();
            klasa.regularPrint();
        }
        {
            System.out.println("\nprimjer 31: interface w polymorphism\n");
            MyInterface1 interface1 = new IntefaceImpl();
            MyInterface2 interface2 = new DoubleInterfaceImpl();
            interface1.methodOne();
            interface2.methodTwo();
            // interface2.methodOne(); // error: cannot find symbol "method methodOne()" in "osnove.MyInterface2"
        }
        {
            System.out.println("\nprimjer 32: enum\n");
            MyEnum myEnum = MyEnum.TEST;
            System.out.println(myEnum);
        }
        {
            System.out.println("\nprimjer 33: nested enum\n");
            Klasa.NestedEnum myEnum = Klasa.NestedEnum.HELLO;
            System.out.println(myEnum);
        }
        {
            System.out.println("\nprimjer 34: wrapper classes\n");
            Integer myIntObject = 2;
            int myIntPrimitive = 3;
            System.out.println(myIntObject-myIntPrimitive);
        }
        {
            System.out.println("\nprimjer 35: casting\n");
            Integer myIntObject = 2;
            int myIntPrimitive = 3;
            Float myFloatObject = myIntObject.floatValue();
            System.out.println(myFloatObject);
            String myString = myIntObject.toString();
            System.out.println(myString);
            //myString = ((String) myIntPrimitive); // error: cannot cast 'int' to 'java.lang.String'
            myString = Integer.toString(myIntPrimitive);
            System.out.println(myString);
        }
        {
            System.out.println("\nprimjer 36: native array\n");
            int[] myArray = {1,2,3};
            for (int i = 0; i < 3; i++){
                System.out.println(myArray[i]);
            }
        }
        {
            System.out.println("\nprimjer 37: ArrayList\n");
            List<Integer> myArray = new ArrayList<>();
            myArray.add(1);
            myArray.add(2);
            myArray.add(3);
            for (int i = 0; i < 3; i++){
                System.out.println(myArray.get(i));
            }
        }
        {
            System.out.println("\nprimjer 38: ArrayList vs Array\n");
            List<Integer> myListArray = new ArrayList<>();
            int[] myNativeArray = {1,2,3};
            //List<int> myListArray2; // error: cannot be of primitive type
            myListArray.add(1);
            myListArray.add(2);
            myListArray.add(3);
            //myNativeArray.add(4): // error: native array is of fixed size
            for (int i = 0; i < 3; i++){
                System.out.println(myListArray.get(i));
                System.out.println(myNativeArray[i]);
            }
        }
        {
            System.out.println("\nprimjer 39: Linked List\n");
            List<Integer> myArray = new LinkedList<>();
            myArray.add(1);
            myArray.add(2);
            myArray.add(3);
            for (int i = 0; i < 3; i++) {
                System.out.println(myArray.get(i));
            }
        }
        {
            System.out.println("\nprimjer 40: Iterator\n");
            List<Integer> myArray = new LinkedList<>();
            myArray.add(1);
            myArray.add(2);
            myArray.add(3);
            for (Iterator<Integer> it = myArray.iterator(); it.hasNext();) {
                System.out.println(it.next());
            }

        }
        {
            System.out.println("\nprimjer 41: for each loop\n");
            List<Integer> myArray = new ArrayList<>();
            myArray.add(1);
            myArray.add(2);
            myArray.add(3);
            for (Integer i : myArray){
                System.out.println(i);
            }
        }
        {
            System.out.println("\nprimjer 42: stream\n");
            List<Integer> myArray = new ArrayList<>();
            myArray.add(1);
            myArray.add(2);
            myArray.add(3);
            myArray.stream().forEach(integer -> System.out.println(integer));
        }
        {
            System.out.println("\nprimjer 43: stream map\n");
            List<Integer> myArray = new ArrayList<>();
            myArray.add(1);
            myArray.add(2);
            myArray.add(3);
            myArray.stream().map(integer -> integer+5);
            myArray.stream().forEach(integer -> System.out.println(integer));

        }
        {
            System.out.println("\nprimjer 44: stream native array \n");
            int[] myNativeArray = {1,2,3};
            Arrays.stream(myNativeArray).forEach(integer -> System.out.println(integer));
        }
        {
            System.out.println("\nprimjer 45: List cast w stream\n");
            List<Integer> myArray = new ArrayList<>();
            myArray.add(1);
            myArray.add(2);
            myArray.add(3);
            List<Float> myFloatArray = myArray.stream().map(integer -> integer.floatValue()).collect(Collectors.toList());
            myFloatArray.stream().forEach(aFloat -> System.out.println(aFloat));
        }
        {
            System.out.println("\nprimjer 46: Map\n");
            Map<Integer,String> myMap = new HashMap<>();
            myMap.put(1,"hello");
            myMap.put(3,"World");
            myMap.put(26,"!!!!");
            for (Map.Entry<Integer,String> entry: myMap.entrySet()) {
                System.out.println(entry);
            }
        }
        {
            System.out.println("\nprimjer 47: Files create \n");
            File myFile = new File("filename.txt");
            try {
                boolean created = myFile.createNewFile();
                System.out.println("Is the file created: "+created);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        {
            System.out.println("\nprimjer 48: Files read\n");
            File myFile = new File("filename.txt");


            try {
                Scanner myReader = new Scanner(myFile);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        {
            System.out.println("\nprimjer 49: Files write\n");
            try {
                FileWriter myWriter = new FileWriter("filename.txt");
                myWriter.write("Hello world");
                myWriter.close();

                Scanner myReader = new Scanner(new File("filename.txt"));
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                myReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        {
            System.out.println("\nprimjer 50: Files delete\n");
            File myFile = new File("filename.txt");
            boolean deleted = myFile.delete();
            System.out.println("Is the file deleted: "+deleted);
        }
    }
}
