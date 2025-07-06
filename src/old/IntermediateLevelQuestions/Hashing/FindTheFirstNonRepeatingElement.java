package old.IntermediateLevelQuestions.Hashing;

import java.util.HashMap;

public class FindTheFirstNonRepeatingElement {
    /*
      Example :
      arr = {1,2,3,1,2,5};  ans = 3
      arr = {4,3,3,2,5,6,4,5};  ans = 2
      arr = {2,6,8,4,7,2,9};   ans = 6
     */

    public static void main(String[] args) {
        int[] A = {2,6,8,4,7,2,9};
        // brute force
        int n = A.length;

     /*   int ans = -1;

        for(int i=0;i<n;i++){
            boolean status = false;
            for(int j=0;j<n;j++){
                if(A[i]==A[j] & (i!=j)){
                    status = true;
                    break;
                }
            }
            if(!status) {
                ans = A[i];
                break;
            }
        }
        System.out.println(ans);
        */

        //// Optimal approach
        /*
              first storing the array elements in hashmap with their respective frequency
              and then iterating array to find first element with only 1 occurence
         */
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<A.length;i++){
            if(map.containsKey(A[i])){
                map.put(A[i], map.get(A[i])+1);
            }else {
                map.put(A[i], map.getOrDefault(A[i],0)+1);
            }
        }
        int ans = -1;
        for (int i :A){
            if(map.get(i)==1){
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}
