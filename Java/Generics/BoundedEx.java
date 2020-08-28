
interface Human {
    public void speak();
    public void walk();
}

class Graduation<T extends Study & Human> {
    T obj;

    Graduation(T obj) {
        this.obj = obj;
    }

    public void start() {
        obj.speak();
        System.out.println(obj.getClass().getSimpleName() + 
                " got graducated in " + obj.getStream());
        obj.walk();
    }
}

class Study {
    String stream;

    Study(String stream) {
        this.stream = stream;
    }

    String getStream() {
        return stream;
    }
}

class Monkey extends Study {
    Monkey() {
        super("CSE");
    }
}

class Lawrance extends Study implements Human {

    Lawrance() {
        super("CSE");
    }

    public void speak() {
        System.out.println("Lawrance Speaking");
    }
    public void walk() {
        System.out.println("Lawrance Walking");
    }
}

class Rubesh implements Human {
    public void speak() {
        System.out.println("Rubesh Speaking");
    }
    public void walk() {
        System.out.println("Rubesh Walking");
    }
}

public class BoundedEx {
    public static void main (String[] args) {
        Lawrance lawrance = new Lawrance();
        Rubesh rubesh = new Rubesh();
        Graduation<Lawrance> grad = new Graduation<>(lawrance);
        grad.start();
        Graduation<Monkey> grad2 = new Graduation<>(new Monkey()); // This line will throw an Error
    }
}
