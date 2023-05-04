package KE2;

public class PrintableList {
    private Entry header = new Entry(null, null, null);
    private int size;
    
    public PrintableList() {
        header.next = header;
        header.previous = header;
    }
    
    private static class Entry {
        private Printable elem;
        private Entry next;
        private Entry previous;
        
        private Entry (Printable element, Entry next, Entry previous) {
            this.elem = element;
            this.next = next;
            this.previous = previous;
        }    
    }
    public class ListIterator {
        private int nextIndex;
        private Entry next = header.next;
        
        public boolean hasNext() {
            return nextIndex != size;
        }
        
        public Printable next() {
            if (nextIndex == size) throw new java.util.NoSuchElementException();
            Printable elem = next.elem;
            next = next.next;
            nextIndex++;
            return elem;
        }
    }
    
    public ListIterator listIterator() {
        return new ListIterator();
    }
    
    void addLast(Printable elem) {
        Entry newEntry = new Entry(elem, header, header.previous);
        header.previous.next = newEntry;
        header.previous = newEntry;
        size++;
    }
    
    public Printable getLast() {
        if (size == 0) throw new java.util.NoSuchElementException();
        return header.previous.elem;
    }
    
    public Printable removeLast() {
        Entry lastEntry = header.previous;
        if (lastEntry == header) throw new java.util.NoSuchElementException();
        lastEntry.previous.next = lastEntry.next;
        lastEntry.next.previous = lastEntry.previous;
        size--;
        return lastEntry.elem;
    }
    
    public int size() {
        return size;
    }
}



class Persona implements Printable {
    private String name;
    
    Persona(String name){
        this.name = name;
    }
    
    @Override
    public void print() {
        System.out.println(name);
    }
}

class Cat implements Printable {
    
    @Override
    public void print() {
        System.out.println("Miau!");
    }
}

class Book implements Printable {
    private String title;
    
    Book(String title){
        this.title = title;
    }
    
    @Override
    public void print() {
        System.out.println(title);
    }
}

interface Printable {
    void print();
}
