package AdvanceLevelQuestions.BinarySearch;

public class FindThePeakElement {
    /*
Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time. The array may have duplicate elements.


1 <= |A| <= 100000

1 <= A[i] <= 10^9


Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.


Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explaination
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.
     */

    public static void main(String[] args) {

        int[] A = {11,13,15,17};

        System.out.println(findPeakElement(A));
    }

    public static int findPeakElement(int[] A){
        int s = 0;
        int e = A.length-1;

        while(s<e){
            int m = s + (e-s)/2;
            if(A[m] < A[m+1] &&(A[m-1] < A[m+1])){
                e = m - 1;
            }else{
                s = m;
            }
        }
        return e;
    }

    /* Code Explaination :

     There are following ways of peak :
     1) a1<a2<a3  , a3 is peak
     2) a1>a2>a3   ,a1 is peak
     3) a1<a2>a3  , a2 is peak

    Here while using binary search, we will observe that ,
    if A[mid]<A[mid+1] then it means ,there exist a peak  somewhere between mid+1 to end
       this doesn't necessarily mean that no peak exist before mid-index.

       BUT any peak can be considered so,we are choosing like this






     */

}
