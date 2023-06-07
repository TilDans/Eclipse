package KE4;

public class Bruch {

    public Bruch(int zaehler, int nenner) throws NennerIstNullException {
        if (nenner == 0)    {
            throw new NennerIstNullException();
        }
    }
    
    public static void main(String[] args) throws NennerIstNullException   {
            Bruch b = new Bruch(2, 0);
    }
}


class NennerIstNullException extends Exception  {
    
}