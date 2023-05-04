package KE2;

public class Fraction {
    private int numerator;
    private int denominator;
    
    public Fraction(int numerator, int denominator) 
            throws IllegalArgumentException {
        if (denominator == 0)
            throw new IllegalArgumentException("Nenner ist 0.", null);
        this.numerator = numerator;
        this.denominator = denominator;
    }   
    
    Fraction getProductOfThisAnd(Fraction and) {
        return new Fraction(this.numerator * and.numerator, this.denominator * and.denominator);
    }
    
    
    @Override
    public String toString()   {
        return numerator + "/" + denominator;
    }    

public static void main(String[] args)  {
    Fraction a = new Fraction(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    System.out.println(a);
    String x ="Hello";
    Fraction b = new Fraction(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
    System.out.println(b);
    Fraction c = new Fraction(Integer.parseInt(args[4]), Integer.parseInt(args[5]));
    System.out.println(c);
    int[] test = {99,21,23,8,83,35,14,4,3,10};
    java.util.Arrays.sort(test);
    java.util.Arrays.toString(test);
    for (int i = 0; i < 10; i++)
        System.out.println(test[i]);
}
}