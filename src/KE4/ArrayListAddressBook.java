package KE4;

import java.util.ArrayList;

public class ArrayListAddressBook {
    private ArrayList<Person> persons;
    
    ArrayListAddressBook(){
        persons = new ArrayList<Person>();
    }
    
    void addP (Person newpers) {
        persons.add(newpers);
    }
    
    void print() {
        System.out.println("Anzahl der Einträge = " + persons.size());
        System.out.println("_______________________________________________________________");
        for (Person p : persons) {
            System.out.println();
            p.print();
            System.out.println("_______________________________________________________________");
        }
    }
    public static void main(String[] args) {
        ArrayListAddressBook a = new ArrayListAddressBook();
        a.addP(new Person("Tilman", "Sanders"));
        a.print();
    }
}


class Person {
    String firstname;
    String name;
    
    Person(String firstname, String name){
        this.firstname = firstname;
        this.name = name;
    }
    
    void print() {
        System.out.println(name + ", " + firstname);
    }
}