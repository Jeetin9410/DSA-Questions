package old.IntermediateLevelQuestions.Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class K_Occurences {
    /*
    Groot has N trees lined up in front of him where the height of the i'th tree is denoted by H[i].

He wants to select some trees to replace his broken branches.

But he wants uniformity in his selection of trees.

So he picks only those trees whose heights have frequency B.

He then sums up the heights that occur B times. (He adds the height only once to the sum and not B times).

But the sum he ended up getting was huge so he prints it modulo 10^9+7.

In case no such cluster exists, Groot becomes sad and prints -1.

1.   1<=N<=100000
2.   1<=B<=N
3.   0<=H[i]<=10^9

Input: Integers N and B and an array C of size N

Output: Sum of all numbers in the array that occur exactly B times.

Example:

Input:

N=5 ,B=2 ,C=[1 2 2 3 3]
Output:

5
     */
    public static void main(String[] args) {
        int N = 6;
        int B = 2;
        int[] A = {1000000000,1000000000,999999999,999999999,999999998,1};
        int mod = 1000000000+7;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            if(map.containsKey(A[i])){
                map.put(A[i],map.get(A[i])+1);
            }else{
                map.put(A[i],map.getOrDefault(A[i],0)+1);
            }
        }
        int sum = 0;
        boolean status = false;
        for(Integer key : map.keySet()){
            if(map.get(key) == B){
                status = true;
                sum = (sum+key)%mod;
            }
        }

       // (status)?return sum : return -1;
        System.out.println(sum);

    }
}
