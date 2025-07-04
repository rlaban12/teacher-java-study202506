
class Parent {
    public static void display() {
        System.out.println("A");
    }
}

class Child extends Parent {
    public static void display() {
        System.out.println("B");
    }
}

public class Main {

    static void printDisplay(Parent obj) {
        obj.display();
    }

    public static void main(String[] args) {
        Parent x1 = new Parent();
        Parent x2 = new Child();
        Child x3 = new Child();

        printDisplay(x1);
        printDisplay(x2);
        printDisplay(x3);
    }
}