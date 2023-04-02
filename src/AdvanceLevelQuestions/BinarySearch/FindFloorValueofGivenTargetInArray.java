package AdvanceLevelQuestions.BinarySearch;

public class FindFloorValueofGivenTargetInArray {
    /*    Problem statement
       Given a sorted Array (Ascending order)
       Find the floor of a given value k.

       floor(k) ==> The largest no. less than or
                    equal to k.

     */
    public static void main(String[] args) {
        int[] A = {1,2,3,4,7,8,9,10};
        int k =6;
        /* Approach :

        we will follow Binary search approach along with that
        --> we will check if A[mid] < key
        if yes store that as best possible answer
         this will take place till
         start== end
         */

        System.out.println(findFloorValueinGivenArray(A,k));
    }
    public static int findFloorValueinGivenArray(int[] A, int k){
        int s=0;
        int e=A.length-1;
        int ans=k;
        while(s<e){
            int mid = s + (e-s)/2;
            if(k==A[mid])
                return A[mid];
            if(k<A[mid]){

                e = mid -1;
            }else{
                ans = A[mid];
                s = mid +1;
            }
        }

        return ans;
    }
}
