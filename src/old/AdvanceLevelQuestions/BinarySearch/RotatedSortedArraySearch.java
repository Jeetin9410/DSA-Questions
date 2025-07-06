package old.AdvanceLevelQuestions.BinarySearch;

public class RotatedSortedArraySearch {
    /*

Given a sorted array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index otherwise, return -1.

You may assume no duplicate exists in the array.

NOTE: Users are expected to solve this in O(log(N)) time.



1 <= N <= 1000000

1 <= A[i] <= 10^9

all elements in A are distinct.

Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return index of B in array A, otherwise return -1



Example Input
Input 1:

A = [4, 5, 6, 7, 0, 1, 2, 3]
B = 4
Input 2:

A : [ 9, 10, 3, 5, 6, 8 ]
B : 5


Example Output
Output 1:

 0
Output 2:

 3


Example Explanation
Explanation 1:

Target 4 is found at index 0 in A.
Explanation 2:

Target 5 is found at index 3 in A.
     */

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};

        int B = 12;
        /*  Approach 1: Find Peak element and binary search the target in required portion */
      /*  int peakElementIndex = findPeakElement(A);
        System.out.println(peakElementIndex);
        System.out.println(searchElement(A,0,peakElementIndex,B)); */
        /*
        Issue in above approach:
        As we are interested in finding peak, we are missing a case, were  a1 > a2 > a3< a4 <a5
        ie. deep point , which lowest in entire array

        So we need to find pivot point. i,e a point or element in array after which the array start strictly increasing or decreasing...
        ex : A = 5,1,3 ===> 1 is pivot point


            Below approach is not working for all cases (Hard Cases)



         */

/*        int pivotIndex = findPivotElement(A);

        if(pivotIndex==0 || pivotIndex==A.length-1 ){
            System.out.println(searchElement(A,0,A.length-1,B));
        }else if(B>=A[0] && B<=A[pivotIndex-1]){
            System.out.println(searchElement(A,0,pivotIndex-1,B));
        }else{
            System.out.println(searchElement(A,pivotIndex,A.length-1,B));
        }
*/

        /* Approach 2 :
        * Explanation : https://www.youtube.com/watch?v=Le8bc8aHgBA&ab_channel=AnujBhaiya
        *  */

        System.out.println(ModifiedBinarySearch(A,B));


    }


    public static int ModifiedBinarySearch(int[] A, int key){
            int s = 0;
            int e = A.length-1;

            while(s<=e){
                int m = s + (e-s)/2;
                if(A[m]==key){
                    return m;
                }
                if(A[s] <= A[m]){
                    if(key>=A[s] && key<=A[m]){
                        e = m-1;
                    }else{
                        s = m+1;
                    }
                }else{
                    if(key >= A[m] && key <= A[e]){       // these = sign are v v v important, otherwise the code will not work
                                                         // for the cases where there are more then 1 peak.
                        s = m+1;
                    }else {
                        e = m-1;
                    }
                }
            }
            return -1;
    }

  /*  public static int searchElement(int[] A, int start, int end, int key){
        while(start<=end){
            int m = start + (end - start)/2;
            if(key == A[m]){
                return m;
            } else if (key < A[m]) {
                end = m-1;
            }else {
                start = m+1;
            }
        }
        return -1;
    }

    public static int findPivotElement(int[] A){
        int s = 0;
        int e = A.length-1;

        while(s<e){
            int m = s + (e-s)/2;
            if(A[m] < A[m+1] &&(A[m-1] < A[m+1])){
                s=m+1;
            }else{
                e = m;
            }
        }

        return s;
    }
*/
}
