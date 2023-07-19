import java.util.Scanner;

public class SuminBinaryTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            long n = in.nextLong();
            long sum = 0;
            while(n > 0){
                sum += n;
                n = n / 2;
            }
            System.out.println(sum);
        }
    }   
}