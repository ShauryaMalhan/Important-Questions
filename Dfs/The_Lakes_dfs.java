import java.io.PrintWriter;
import java.util.*;
 
public class main {
    
    static int n;
    static int m;
	static ArrayList<ArrayList<Boolean>> visited;
	static ArrayList<ArrayList<Integer>> obj;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = in.nextInt();
        while(t-- > 0){
            n = in.nextInt();
            m = in.nextInt();
            obj = new ArrayList<>();
            visited = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                obj.add(new ArrayList<>());
                visited.add(new ArrayList<>());
                for (int j = 0; j < m; j++) {
                    visited.get(i).add(false);
                    obj.get(i).add(in.nextInt());
                }
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(!visited.get(i).get(j) && obj.get(i).get(j) != 0){
                        pw.println(visited);
                        sum = Math.max(sum, dfs(i, j));
                    }
                }
            }
            pw.println(sum);
        }
	    pw.close();
    }
    public static int dfs(int i, int j){
        visited.get(i).set(j, true);
        int ans = obj.get(i).get(j);
        if(i != 0 && !visited.get(i - 1).get(j) && obj.get(i - 1).get(j) != 0){
            ans += dfs(i - 1, j);
        }
        if(j != 0 && !visited.get(i).get(j - 1) && obj.get(i).get(j - 1) != 0){
            ans += dfs(i, j - 1);
        }
        if(i != n - 1 && !visited.get(i + 1).get(j) && obj.get(i + 1).get(j) != 0){
            ans += dfs(i + 1, j);
        }
        if(j != m - 1 && !visited.get(i).get(j + 1) && obj.get(i).get(j + 1) != 0){
            ans += dfs(i, j + 1);
        }
        return ans; 
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
