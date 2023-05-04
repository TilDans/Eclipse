package KE2;

public class MaxWeightContainer {
    private Weighable heaviest;
    
    public void store(Weighable element) {
        if (heaviest == null ||
                element.getWeight() > heaviest.getWeight()) {
        heaviest = element;
        }
    }
    
    public Weighable getHeaviest() {
        return heaviest;
    }
    
    public static void main(String[] args)  {
        MaxWeightContainer mwc = new MaxWeightContainer();
        Apple apple1 = new Apple(4.5d, "bitter");
        Apple apple2 = new Apple(2.3d, "sweet");
        Apple apple3 = new Apple(4.9d, "mealy");
        Apple apple4 = new Apple(3.5d, "bitter");
        Animal anim1 = new Animal(9.2d, "Husky");
        Animal anim2 = new Animal(15.2d, "Sheperd");
        Animal anim3 = new Animal(30.2d, "Retriever");
        Animal anim4 = new Animal(12.2d, "Berner");
        mwc.store(apple1);
        mwc.store(apple2);
        mwc.store(apple3);
        mwc.store(apple4);
        mwc.store(anim1);
        mwc.store(anim2);
        mwc.store(anim3);
        mwc.store(anim4);
        Weighable heavy = mwc.getHeaviest();
        System.out.println(heavy.getWeight());
    }
}




class Animal implements Weighable {
    double weight;
    String breed;
    
    Animal(double weight, String breed) {
        this.weight = weight;
        this.breed = breed;
    }
    
    public double getWeight() {
        return weight;
    }
}


class Apple implements Weighable {
    double weight;
    String taste;
    
    Apple(double weight, String taste) {
        this.weight = weight;
        this.taste = taste;
    }
    
    public double getWeight() {
        return weight;
    }
}


interface Weighable {
    double getWeight();
}