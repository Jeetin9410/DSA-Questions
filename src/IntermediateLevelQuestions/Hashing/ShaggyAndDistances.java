package IntermediateLevelQuestions.Hashing;

import java.util.Arrays;
import java.util.HashMap;

public class ShaggyAndDistances {
    /*
    Shaggy has an array A consisting of N elements.
    We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.

    Shaggy wants you to find a special pair such that the distance between that pair is minimum.
     Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.

     1 <= |A| <= 10^5

     Example Input
Input 1:

A = [7, 1, 3, 4, 1, 7]
Input 2:

A = [1, 1]


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

Here we have 2 options:
1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
Therefore the minimum possible distance is 3.
Explanation 2:

Only possibility is choosing A[1] and A[2].
     */

    public static void main(String[] args) {
        int[] A = {1, 1};
        int n = A.length;
        HashMap<Integer,Integer> map = new HashMap<>();  // num, its last occurence
        int len = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(map.containsKey(A[i])){
                int olderIndex = map.get(A[i]);
                int temp = i - olderIndex;
                if (temp < len){
                    len = temp;
                }
                map.put(A[i],i);

            }else{
                map.put(A[i],i);
            }
        }

        System.out.println(len);
        System.out.println(Arrays.asList(map));
    }

}
