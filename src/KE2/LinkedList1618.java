package KE2;

class LinkedList1618 {
    Entry header = new Entry(null, null, null);
    int size;
    
    /* Constructs an empty Linked List. */
    LinkedList1618() {
        header.next = header;
        header.previous = header;
    }
    
    /* Returns the last Element in this List. */
    Person getLast() {
        if (size == 0) throw new java.util.NoSuchElementException();
        return header.previous.element;
    }
    
    /* Removes and returns the last Element from this List. */
    Person removeLast() {
        Entry lastEntry = header.previous;
        if (lastEntry == header) throw new java.util.NoSuchElementException();
        lastEntry.previous.next = lastEntry.next;
        lastEntry.next.previous = lastEntry.previous;
        size--;
        return lastEntry.element;
    }
    
    /* Appends the given element to the end of this List. */
    void addLast(Person p) {
        Entry newEntry = new Entry(p, header, header.previous);
        header.previous.next = newEntry;
        header.previous = newEntry;
        size++;
    }
    
    /* Returns the number of elements in this List. */
    int size() {
    return size;
    }
    
    Person getElementAt(int position)  {
        if (position < 0 || position >= size) throw new java.util.NoSuchElementException();
        Entry elem = header.next;
        for (int i = 0; i < position; i++)  {
            elem = elem.next;
        }
        return elem.element;
    }
    
    private static class Entry {
        private Person element;
        private Entry next;
        private Entry previous;
        
        private Entry (Person element, Entry next, Entry previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }    
    }
    
    class ListIterator {
        private int nextIndex;
        private Entry next = header.next;
        
        boolean hasNext() {
        return nextIndex != size;
        }
        
        Person next() {
        if (nextIndex == size)
        throw new java.util.NoSuchElementException();
        Person elem = next.element;
        next = next.next;
        nextIndex++;
        return elem;
        }
     }
     ListIterator listIterator() {
     return new ListIterator();
     }
        
}

class Person {
    private String firstName;
    private String lastName;
    
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    String getFirstName() {
        return firstName;
    }
    
    String getLastName() {
        return lastName;
    }
    
    void print()    {
        System.out.println(lastName + ", " + firstName);
    }
}

class ListTest {
    public static void main(String[] args) {
        LinkedList1618 personList = new LinkedList1618();
        Person p0 = new Person("vorname_0", "Test");
        personList.addLast(p0);
        Person p1 = new Person("vorname_1", "Test");
        personList.addLast(p1);
        Person p2 = new Person("vorname_2", "Test");
        personList.addLast(p2);
        Person p3 = new Person("vorname_3", "Test");
        personList.addLast(p3);
        Person p4 = new Person("vorname_5", "Test");
        personList.addLast(p4);
        for (int i = 0; i < personList.size; i++) {
            Person p = personList.getElementAt(i);
            p.print();
        }
     }
}