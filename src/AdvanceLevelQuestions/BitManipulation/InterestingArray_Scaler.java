package AdvanceLevelQuestions.BitManipulation;

public class InterestingArray_Scaler {

    /*
    You have an array A with N elements. We have two types of operation available on this array :
    We can split an element B into two elements, C and D, such that B = C + D.
    We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.

    You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0
    after several splits and/or merge?

    1 <= N <= 100000

    1 <= A[i] <= 10^6

     Input Format
    The first argument is an integer array A of size N.

    Output Format
    Return "Yes" if it is possible otherwise return "No".

    Example Input
Input 1:

 A = [9, 17]
Input 2:

 A = [1]


Example Output
Output 1:

 Yes
Output 2:

 No


     */

    public static void main(String[] args) {

       /*
       Approach :

       target is to reduce the given array to 0.
       So if we think XOR operator for this solution,then we observe that XOR operator return 0 when both operands are
        and this property we can use....
        it is easy in case of even , cause it can be splitted into 2 equal halfs and there XOR will be 0. which is given in
        in case of odd : we will split it as (arr[i]-1 and 1) and arr[i]-1 is even which can be reduced 0.
        Therefore odd element can be reduced to 1. now how to reduce this condition to 0.
        SO WHAT IT  ? no odd elements are even in the given array....now all the 1 be even which can be reduced to 0

        SO MORAL OF THIS : If the no of odd elements are even then they can be reduced to zero
        
        */
        
        int[] A = {3,3,3};

        int count = 0;

        for (int i=0;i<A.length;i++) {
            if(A[i]%2 ==1){   // the number is odd
                count++;
            }
        }

        if(count % 2 ==0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

        /// Approach 2 :
        /*
        The approach is rather simple, we just have to find the XOR of the elements of the array and if it’s odd,
         then dividing or splitting it will be of any use as every time the value of XOR will always come odd,
         and if it’s even we have our answer i.e. 0.
         */

        int ans = A[0];
        for(int i=1;i<A.length;i++){
            ans = ans^A[i];
        }

        if(ans%2==0){
            System.out.println("YES");
        }else{
            System.out.println("No");
        }

    }

}
