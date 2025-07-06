package old.AdvanceLevelQuestions.BinarySearch;

public class FindSingleElementByBinarySearch {

    /////// Good Question
    /*
     Every Element appears twice except one element. Find the single element.
     **All the pairs  of duplicate will always be adjacent to each other.

     example :
    A = 3,3,1,1,8,8,10,10,6,2,2,4,4

    6 is the answer.

     */
    public static void main(String[] args) {
        /* Concept :

        It is provided that the duplicate of every element lie adjacent to it.

        AND, ONLY AND ONLY BECAUSE OF THIS PROPERTY , we can use binary search to solve this,otherwise
        Binary search wont work.

        So this thing can be used to apply binary Search.

        Property :

        If we look closely ,
        (Index starting from 0)
        ** Before The Required single element

        ==> 1st occurrence of all the pair is present at even index
        ==> 2nd occurrence of all the pairs is present at odd index.

        ** After the Required single element

        ==> 1st occurrence of all the pair is present at odd index.
        ==> 2nd occurrence of all the pairs is present at even index.

   Index :   0  1  2  3  4  5  6   7   8  9  10  11  12
   Array     3  3  1  1  8  8  10  10  6  2  2   4   4

         */
       int[] A = {3,3,1,1,8,8,10,10,6,2,2,4,4};

        System.out.println(ModifiedBinarySearch(A));

    }
    public static int ModifiedBinarySearch(int[] A){
        int low = 0;
        int high = A.length-1;
        int mid = low + (high -low)/2;
        while(low<high){
            if(mid%2==0){
                if(A[mid] == A[mid+1]){
                    low = mid +2;
                }else{
                    high = mid;
                }
            }else{
                if(A[mid] == A[mid-1]){
                    low = mid+1;
                }else{
                    high = mid -1;
                }
            }
            mid = low + (high -low)/2;
        }
        return A[mid];
    }
}
