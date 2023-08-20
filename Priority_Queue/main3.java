import java.io.PrintWriter;
import java.util.*;

public class main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            ArrayList<Pair> a = new ArrayList<>();
            Boolean flag = true;
            int[] cnt = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int d = in.nextInt();
                a.add(new Pair(i, d));
                cnt[d]++;
            }
            Collections.sort(a);
            PriorityQueue<Integer> c = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 1; i <= n; i++) {
                int d = (int) a.get(i - 1).value;
                if(d < i || cnt[i] > 2){
                    flag = false;
                    break;
                }
                if(cnt[i] == 0){
                    c.add(i);
                }
            }
            if(flag){
                pw.println("yes");
                int i = n - 1;
                ArrayList<Integer> obj = new ArrayList<>(Collections.nCopies(n, 0));
                ArrayList<Integer> obj1 = new ArrayList<>(Collections.nCopies(n, 0));
                while(i >= 0){
                    int d = (int) a.get(i).value;
                    int m = (int) a.get(i).key;
                    if(cnt[d] == 1){
                        obj.set(m, d);
                        obj1.set(m,d);
                    }
                    if(cnt[d] == 2){
                        int k = c.poll();
                        obj.set(m, d);
                        obj1.set(m, k);
                        i--;
                        m = (int) a.get(i).key;
                        obj.set(m, k);
                        obj1.set(m, d);
                    }
                    i--;
                }
                for (int l = 0; l < obj.size(); l++) {
                    pw.print(obj.get(l) + " ");
                }
                pw.println();
                for (int l = 0; l < obj1.size(); l++) {
                    pw.print(obj1.get(l) + " ");
                }
                pw.println();
            }else{
                pw.println("no");
            }
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
    public static int calcMex(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        for (int i = 0; i <= list.size(); i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return list.size();
    }
    public static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b % a, a);
    }
}