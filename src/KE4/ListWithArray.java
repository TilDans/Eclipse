package KE4;

public class ListWithArray<ET>{
    Object [] objects;
    int size;
    
    
    ListWithArray(int capacity){
        if (capacity < 1) 
            capacity =1;
        this.objects = new Object[capacity];
    }    
    
    void doubleArray()   {
        Object[] newArr = new Object[2 * objects.length];
            for(int i = 0; i < objects.length; i ++)    {
                newArr[i] = objects[i];
            }
            objects = newArr;
    }
    
    public void addLast(ET elem) {
        if (size == objects.length)  {
            doubleArray();
        }
        objects[size] = elem;
        size++;
    }
    
    public ET getLast() {return (ET) objects[size - 1];}
    
    public ET removeLast() {
            int i = 0;
            while (objects[i + 1] != null) {
                i++;
            }
            ET removed = (ET) objects[i];
            objects[i] = null;
            return removed;
    }
    
    public int getSize() {return size;}
    
    void print() { System.out.println("Arraygröße : " + objects.length + " | Anzahl enthaltener Elemente: " + size);} 
    
    public static void main(String[] args) {
        ListWithArray<String> a = new ListWithArray(3);
        a.removeLast();
        a.addLast("1");
        System.out.println(a.getLast()); 
        a.addLast("2");
        a.addLast("3");
        a.addLast("4");
        a.print(); 
        a.addLast("5");
        System.out.println(a.getLast()); 
        a.addLast("6");
        a.addLast("7");
        System.out.println(a.getLast());
        a.print();
        System.out.println(a.getLast());
        a.removeLast();
        System.out.println(a.getLast());
        a.print();
    }
}