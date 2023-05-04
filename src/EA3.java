
public class EA3 {
    public static void main(String[] args) {
        int[] newcode = {42, 15, 11, 22, 3, 31, 6, 33, 9, 2, 1};
        int[] linhash = new int[11];
        int[] doublehash = new int[11];
        int[] doublehash2 = new int[11];
        
        for (int i = 0; i < newcode.length; i++) {
            linhash[i] = newcode[i]%13;
        }
        for (int i = 0; i < newcode.length; i++) {
            doublehash[i] = ((newcode[i]%13)+(1+(newcode[i]%11)))%13;
        }
        for (int i = 0; i < newcode.length; i++) {
            doublehash2[i] = ((newcode[i]%13)+((1+(newcode[i]%11))*4))%13;
        }
        
        
        System.out.println("doublehash: ");
        for (int i = 0; i < newcode.length; i++) {
            System.out.println(newcode[i] + "---" + (1+(newcode[i]%11)) + "---" + "---" + doublehash[i] + "---Double2 = " + doublehash2[i]);
        } System.out.println("-------------------------------------------------");
    }
}
