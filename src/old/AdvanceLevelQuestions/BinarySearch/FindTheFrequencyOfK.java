package old.AdvanceLevelQuestions.BinarySearch;

public class FindTheFrequencyOfK {
    /* Problem statement
       Given an Array of size of N, sorted in ascending order.
       Find the frequency of k.


     */
    public static void main(String[] args) {
        int[] A = {-5,-5,-3,0,0,1,1,1,5,5,5,5,5,5,5,9,10};
        int k = 5;

        /*   Brute Force approach
                using for loop ans count the frequency
                TC : O(N)
         */

        /*          Optimal approach, TC : O(LogN)

            We will do BinarySearch with two intensions :
            1) first binarySearch to find the first occurence of given key.
            2) second binarySearch to find the last occurence.

            for first occurence ==> we will shift the end pointer to mid-1.
                                    why? cause we will try to find all k prior to mid index so as soon as we find k in mid
                                    index , we will again try to find if there exist any index < mid where k exist.

            Same for last occurence
         *
         */
        int last = LastOccurenceIndex(A,k);
        int first = FirstOccurenceIndex(A,k);

        System.out.println("Frequency of "+k+" is: "+(last-first));
    }
    public static int FirstOccurenceIndex(int[] A, int k){
        int s = 0;
        int e = A.length-1;
        int firstOccurence = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(k==A[mid]){
             firstOccurence = mid;
             e = mid -1;
            }
            else if(k<A[mid]){
                e = mid - 1;
            }else{
                s = mid +1;
            }
        }
        return firstOccurence;
    }

    public static int LastOccurenceIndex(int[] A, int k){
        int s = 0;
        int e = A.length-1;
        int lastOccurence = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(k==A[mid]){
                lastOccurence = mid;
                s = mid + 1;
            }
            else if(k<A[mid]){
                e = mid - 1;
            }else{
                s = mid +1;
            }
        }
        return lastOccurence;
    }
}
