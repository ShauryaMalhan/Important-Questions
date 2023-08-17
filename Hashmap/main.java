import java.io.PrintWriter;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            HashMap<Integer, Integer> up = new HashMap<>();
            HashMap<Integer, Integer> side = new HashMap<>();
            HashMap<Integer, Integer> diag1 = new HashMap<>();
            HashMap<Integer, Integer> diag2 = new HashMap<>();
            Long ans = (long) 0;
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                up.put(y, up.getOrDefault(y, 0) + 1);
                side.put(x, side.getOrDefault(x, 0) + 1);
                diag1.put(x - y, diag1.getOrDefault(x - y, 0) + 1);
                diag2.put(x + y, diag2.getOrDefault(y + x, 0) + 1);
            }
            for (int val : up.values()) {
                ans += (long) val * (val - 1);
            }
            for (int val : side.values()) {
                ans += (long) val * (val - 1);
            }
            for (int val : diag1.values()) {
                ans += (long) val * (val - 1);
            }
            for (int val : diag2.values()) {
                ans += (long) val * (val - 1);
            }
            pw.println(ans);
        }
	    pw.close();
    }
    static class Pair implements Comparable<Pair>{
        long key;
        long value;
        Pair(long key, long value){
            this.key = key;
            this.value = value;
        }
        @Override
        public int compareTo(Pair that){
            return (int)this.value - (int)that.value;
        }
    }
}