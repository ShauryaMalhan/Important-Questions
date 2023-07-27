/*
 * A tea manufacturer decided to conduct a massive tea tasting. n
 sorts of tea will be tasted by n
 tasters. Both the sorts of tea and the tasters are numbered from 1
 to n
. The manufacturer prepared ai
 milliliters of the i
-th sort of tea. The j
-th taster can drink bj
 milliliters of tea at once.

The tasting will be conducted in steps. During the first step, the i
-th taster tastes the i
-th sort of tea. The i
-th taster drinks min(ai,bi)
 tea (how much is available of the i
-th sort and how much the i
-th taster can drink). ai
 also decreases by this amount.

Then all tasters move to the previous sort of tea. Thus, during the second step, the i
-th taster tastes the (i−1)
-st sort of tea. The i
-th taster drinks min(ai−1,bi)
 tea. The 1
-st person ends the tasting.

During the third step, the i
-th taster tastes the (i−2)
-nd sort of tea. The 2
-nd taster ends the tasting. This goes on until everyone ends the tasting.

Take a look at the tasting process for n=3
, a=[10,20,15]
, b=[9,8,6]
. In the left row, there are the current amounts of each sort of tea. In the right column, there are current amounts of tea each taster has drunk in total. The arrow tells which taster each tea goes to on the current step. The number on the arrow is the amount — minimum of how much is available of the sort of tea and how much the taster can drink.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class TeaTasting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            ArrayList<Long> obj = new ArrayList<>();
            ArrayList<Long> obj2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                obj.add(in.nextLong());
            }
            for (int i = 0; i < n; i++) {
                obj2.add(in.nextLong());
            }
            ArrayList<Long> pre = new ArrayList<>();
            pre.add(obj2.get(0));
            for (int i = 1; i < n; i++) {
                pre.add(pre.get(i - 1) + obj2.get(i));
            }
            ArrayList<Long> rem = new ArrayList<>();
            ArrayList<Integer> freq = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                rem.add((long)0);
                freq.add(0);
            }
            for (int i = 0; i < n; i++) {
                long val = obj.get(i);
                if(i > 0){
                    val += pre.get(i - 1);
                }
                int index = BS(pre, val);
                freq.set(index, freq.get(index) + 1);
                long rm = val;
                if(index > 0){
                    rm -= pre.get(index - 1);
                }

                rem.set(index, rem.get(index) + rm);
            }
            for (int i = 1; i <= n; i++) {
                freq.set(i, freq.get(i) + freq.get(i - 1));
            }
            for (int i = 0; i < n; i++) {
                long x = (i + 1 - freq.get(i)) * obj2.get(i) + rem.get(i);
                System.out.print(x + " ");
            }
            System.out.println();
        }  
    }
    private static int BS(ArrayList<Long> arr, long x){
        if(x > arr.get(arr.size() - 1)){
            return arr.size();
        }
        int left = 0;
        int right = arr.size();
        while(left < right){
            int mid = left + (right - left)/2;
            if(x <= arr.get(mid)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return right;
    }
}