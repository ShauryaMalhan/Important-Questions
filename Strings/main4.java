import java.io.PrintWriter;
import java.util.*;
 
public class main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(reverseVowels(s));
    }
    static String reverseVowels(String s) {
        int n = s.length();
        char[] b = s.toCharArray();
        int i = 0;
        int j = n - 1;
        String a = "aeiouAEIOU";
        while(i < j){
            while(i < j && a.indexOf(b[i]) == -1){
                i++;
            }
            while(i < j && a.indexOf(b[j]) == -1){
                j--;
            }
            char temp = b[i];
            b[i] = b[j];
            b[j] = temp;

            i++;
            j--;
        }
        String answer = new String(b);
        return answer;
    }
}