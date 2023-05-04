package KE3;

public class Persontest {
    public static void main(String[] args) {
        Professor a = new Professor("test", 5200);
        a.print();
        Person b = new Professor("keinGehalt");
        b.print();
    }
}

class Person {
    private String name;
    
    Person(String name) {
        this.name = name;
    }
    
    void print() {
        System.out.print(name + "_");
    }
}

class Student extends Person {
    private int matriculationNumber;
    
    Student(String name, int matriculationNumber) {
        super(name);
        this.matriculationNumber = matriculationNumber;
    }
    
    @Override
    void print() {
        super.print();
        System.out.println(this.matriculationNumber);
    }
}
class Professor extends Person {
    private int earnings;
    
    Professor(String name, int earnings) {
        super(name);
        this.earnings = earnings;
    }
    
    Professor(String name) {
        this(name, 5500);
    }
    
    @Override
    void print() {
        super.print();
        System.out.println(this.earnings);
    }
}
