package KE1;

public class Mento1 {
    public static void main(String[] args) {
        double[][] Noten = new double[12][3];
        Noten[0]= new double[] {1.0, 105.0, 120.0};
        Noten[1]= new double[] {1.3, 100.0, 104.5};
        Noten[2]= new double[] {1.7, 95.0, 99.5};
        Noten[3]= new double[] {2.0, 90.0, 94.5};
        Noten[4]= new double[] {2.3, 85.0, 89.5};
        Noten[5]= new double[] {2.7, 80.0, 84.5};
        Noten[6]= new double[] {3.0, 75.0, 79.5};
        Noten[7]= new double[] {3.3, 70.0, 74.5};
        Noten[8]= new double[] {3.7, 65.0, 69.5};
        Noten[9]= new double[] {4.0, 60.0, 64.5};
        Noten[10]= new double[] {4.7, 50.0, 59.5};
        Noten[11]= new double[] {5.0, 0.0, 49.5};
        
        double punkte = 55.5;
        for (double elem[] : Noten) {
            if ((punkte <= elem[2]) && (punkte >= elem[1]))  {
                System.out.println(elem[0]);
                return;
            }
        }
        System.out.println("Der Wert wurde nicht gefunden");
    }
}
