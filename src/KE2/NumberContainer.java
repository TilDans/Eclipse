package KE2;

public class NumberContainer {
    private Number element;
    
    public void store(Number number) {
        element = number;
    }
    
    public Number getElement() {
        return element;
    }
    public static void main(String[] args)  {
        NumberContainerWithMaximum ncwm = new NumberContainerWithMaximum();
        ncwm.store(2.23);
        ncwm.store(13.456f);
        ncwm.store(20d);
        ncwm.store(-100);
        ncwm.store(20.521313d);
        ncwm.store(1);
        Number test = ncwm.getMaximum();
        System.out.println(test);
    }
}

class NumberContainerWithMaximum extends NumberContainer    {
    private Number maximum;
    
    public Number getMaximum() {
        return maximum;
    }
    
    public void store(Number number)    {
        super.store(number);
        if (maximum == null || number.doubleValue() > maximum.doubleValue())   {
            maximum = number;
        }
    }
}

