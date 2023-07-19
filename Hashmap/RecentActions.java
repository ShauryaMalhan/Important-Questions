import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RecentActions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<Integer> obj = new ArrayList<>();
            HashMap<Integer,Integer> obj2 = new HashMap<>();
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ans.add(0);
            }
            for (int i = 0; i < m; i++) {
                obj.add(in.nextInt());
            }
            int c = 0;
            int j = n - 1;
            for (int i = 0; i < m; i++) {
                c++;
                if(obj2.getOrDefault(obj.get(i), 0) == 0){
                    obj2.put(obj.get(i), i + 1);
                    ans.set(j, c);
                    j--;
                }
                if(j < 0){
                    break;
                }
            }
            while(j >= 0){
                ans.set(j, -1);
                j--;
            }
            for (int i = 0; i < n; i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}