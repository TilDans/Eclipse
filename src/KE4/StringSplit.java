package KE4;


public class StringSplit {
    public static String[] solution(String s) {
        String[] solution;
        if (s.length() == 0) return solution = new String[0];
        if (s.length() % 2 == 0){
           solution = new String[s.length()/2];
           solution[solution.length - 1] = s.substring(s.length() - 2, s.length());
        } else {
           solution = new String[(s.length() + 1)/2];
           solution[solution.length - 1] = s.charAt(s.length() - 1) + "_";
        }
        int i = 0;
        int solcount = 0;
        while (solcount < solution.length - 1) {
          solution[solcount] = s.substring(i, i + 2);
          i = i + 2;
          solcount = solcount + 1;
        }
        return solution;
    }
}

class StringTest{
    public static void main(String[] args) {
        String[] a = StringSplit.solution("abcde");
        for (String elem: a) System.out.println(elem);
    }
}
