package KE3;

public class Weighable implements Printable {
    double weight;
    
    Weighable (double weight){
        this.weight = weight;
    }
    
    @Override
    public void print() {
        System.out.println(weight);
    }
    
    public double getWeight() {
        return weight;
    }
    
    public static void main(String[] args) {
        Printable test = new Letter (1.0, "Til", "Sebastian", "Hi");
        test.print();
        Printable trytest = new PDFDocument(3,"joa guter test");
        trytest.print();
        Printable nochntest = new Parcel(5.0, "Sebastian", "Til", "s");
        nochntest.print();
    }
}

class Dog extends Weighable {
    String breed;
    
    Dog(double weight, String breed){
        super(weight);
        this.breed = breed;
    }
    
    public String getBreed() {
        return breed;
    }
    
}

abstract class PostalItem extends Weighable implements Printable {
    private String sender;
    private String addressee;
    
    PostalItem(double weight, String sender, String addressee){
        super(weight);
        this.sender = sender;
        this.addressee = addressee;
    }
    
    @Override
    public void print() {
        System.out.print("Sender: "+ sender + ". Addressee: " + addressee);
    }
   
    String getSender() {
        return sender;
    }
    
    String getAddressee() {
        return addressee;
    }
}

class Parcel extends PostalItem {
    String parcelsize;
    
    Parcel(double weight, String sender, String addressee, String parcelsize){
        super(weight, sender, addressee);
        this.parcelsize = parcelsize;
    }
    @Override
    public void print() {
        super.print();
        System.out.println(". Size: " + parcelsize);
    }
}

class Letter extends PostalItem {
    String contains;
    
    Letter(double weight, String sender, String addressee, String contains){
        super(weight, sender, addressee);
        this.contains = contains;
    }
    
    @Override
    public void print() {
        super.print();
        System.out.println(". Letter contains: " + contains);
    }
    
    public void test() {
        System.out.println("geglückt");
    }
}

class PDFDocument implements Printable {
    int pages;
    String contains;
    
    PDFDocument(int pages, String contains){
        this.contains = contains;
        this.pages = pages;
    }
    
    @Override
    public void print() {
        System.out.println("Pages: " + pages + ", contains: " + contains);
    }
}

interface Printable{
    void print();
}