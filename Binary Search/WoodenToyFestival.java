// In a small town, there is a workshop specializing in woodwork. Since the town is small, only three carvers work there.

// Soon, a wooden toy festival is planned in the town. The workshop employees want to prepare for it.

// They know that n
//  people will come to the workshop with a request to make a wooden toy. People are different and may want different toys. For simplicity, let's denote the pattern of the toy that the i
// -th person wants as ai
//  (1≤ai≤109
// ).

// Each of the carvers can choose an integer pattern x
//  (1≤x≤109
// ) in advance, different carvers can choose different patterns. x
//  is the integer. During the preparation for the festival, the carvers will perfectly work out the technique of making the toy of the chosen pattern, which will allow them to cut it out of wood instantly. To make a toy of pattern y
//  for a carver who has chosen pattern x
// , it will take |x−y|
//  time, because the more the toy resembles the one he can make instantly, the faster the carver will cope with the work.

// On the day of the festival, when the next person comes to the workshop with a request to make a wooden toy, the carvers can choose who will take on the job. At the same time, the carvers are very skilled people and can work on orders for different people simultaneously.

// Since people don't like to wait, the carvers want to choose patterns for preparation in such a way that the maximum waiting time over all people is as small as possible.

// Output the best maximum waiting time that the carvers can achieve.

// Input
// The first line of the input contains an integer t
//  (1≤t≤104
// ) — the number of test cases.

// Then follow the descriptions of the test cases.

// The first line of a test case contains a single integer n
//  (1≤n≤2⋅105
// ) — the number of people who will come to the workshop.

// The second line of a test case contains n
//  integers a1,a2,a3,…,an
//  (1≤ai≤109
// ) — the patterns of toys.

// The sum of all n
//  values over all test cases does not exceed 2⋅105
// .

// Output
// Output t numbers, each of which is the answer to the corresponding test case — the best maximum waiting time that the carvers can achieve.

// inputCopy                                                    output
// 5                                                            0
// 6                                                            2
// 1 7 7 9 9 9                                                  13
// 6                                                            0
// 5 4 2 1 30 60                                                1
// 9
// 14 19 37 59 1 4 4 98 73
// 1
// 2
// 6
// 3 10 1 17 15 11

import java.util.*;
public class WoodenToyFestival {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-- > 0){
            int n = in.nextInt();
            ArrayList<Long> obj = new ArrayList<>();
            for(int i = 0; i < n; i++){
                obj.add(in.nextLong());
            }
            Collections.sort(obj, Collections.reverseOrder());
            long start = 0;
            long end = (long) 1e9;
            long ans = 0;
            while(start <= end){
                long mid = start + (end - start) / 2;
                if(solve(mid, obj)){
                    ans = mid;
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }
    static boolean solve(long mid, ArrayList<Long> obj){
        ArrayList<Long> check = new ArrayList<>();
        long val = obj.get(0) - mid;
        check.add(val);
        for (int i = 1; i < obj.size(); i++) {
            if(Math.abs(val - obj.get(i)) > mid){
                val = obj.get(i) - mid;
                check.add(val);
            }
        }
        if(check.size() <= 3){
            return true;
        }
        return false;
    }
}