package KE2;

class Toy {
    void print() {
        System.out.println("Toy");
    }
}

class RubberDuck extends Toy {     
    @Override
    public void print() {
        System.out.println("RubberDuck");
    }
}

class TeddyBear extends Toy {
    @Override
    public void print() {
        System.out.println("TeddyBear");
    }
}

class PlasticCar extends Toy { 
    @Override
    void print() {
        System.out.println("PlasticCar");
    }
}

class ToyFactory extends Toy {
    public static Toy getToy(String newtoy) throws NoSuchToyException    {
        switch(newtoy)  {
        case "RubberDuck": 
            return new RubberDuck();
        case "TeddyBear": 
            return new TeddyBear();
        case "PlasticCar": 
            return new PlasticCar();
        default: 
            String message = "RequestedToy: \"" + newtoy + "\" IsNotAvailable";
            throw new NoSuchToyException(message);
        }
    }
}

class NoSuchToyException extends Exception  {
    NoSuchToyException(String message)  {
        super(message);
    }
}

class ToyFactoryTest   {
    public static void main(String[] args) throws NoSuchToyException {
        Toy t1 = ToyFactory.getToy("RubberDuck");
        Toy t2 = ToyFactory.getToy("TeddyBear");
        t1.print();
        t2.print();
        Toy t3 = ToyFactory.getToy("WoodenDinosaur");
        t3.print();
    }
}