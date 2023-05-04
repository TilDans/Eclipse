package KE2;

public class PrintableListTest{
        public static void main(String[] args) {
            PrintableList test = new PrintableList();
            test.addLast(new Cat());
            test.addLast(new Cat());
            test.addLast(new Cat());
            test.addLast(new Cat());
            test.addLast(new Persona("michael"));
            test.addLast(new Persona("max"));
            test.addLast(new Persona("tobias"));
            test.addLast(new Persona("jonas"));
            test.addLast(new Book("goodbook1"));
            test.addLast(new Book("goodbook2"));
            test.addLast(new Book("goodbook3"));
            test.addLast(new Book("goodbook4"));
            PrintableList.ListIterator it = test.listIterator();
            for (int i = 0; i < 20; i++)    {
                Printable elem = it.next();
                elem.print();
            }
        }
}