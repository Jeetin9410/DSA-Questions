package IntermediateLevelQuestions.Arrays.Introduction;

import java.util.*;

public class SeparateOddEven {
    /*
    You are given an integer T denoting the number of test cases.
    For each test case, you are given an integer array A.

    You have to print the odd and even elements of array A in 2 separate lines.

    NOTE: Array elements should have the same relative order as in A.

    1 <= T <= 10
    1 <= |A| <= 10^5
    1 <= A[i] <= 10^9


    Example Input
Input 1:

 2
 5
 1 2 3 4 5
 3
 4 3 2
Input 2:

 2
 3
 2 2 2
 2
 1 1


Example Output
Output 1:

 1 3 5
 2 4
 3
 4 2
Output 2:

 2 2 2
 1 1


Example Explanation
Explanation 1:

 Test Case 1:
 Odd elements in the array(in the order they occur) are: 1, 3, 5.
 Even elements in the array(in the order they occur) are: 2, 4.

 Test Case 2
 Odd elements in the array(in the order they occur) are: 3.
 Even elements in the array(in the order they occur) are: 4, 2.
Explanation 2:

 Test Case 1:
 There are no odd elements in the array.
 Even elements in the array(in the order they occur) are: 2, 2, 2.

 Test Case 2
 Odd elements in the array(in the order they occur) are: 1, 1.
 There are no even elements in the array.

     */

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i =0;i<T;i++){
            int size = sc.nextInt();
            // int[] arr = new int[size];
            ArrayList<Integer> evenArrayList = new ArrayList<Integer>();
            ArrayList<Integer> oldArrayList = new ArrayList<Integer>();
            for(int j =0;j<size;j++){
                int num = sc.nextInt();
                if(num%2==0){evenArrayList.add(num);
                }else { oldArrayList.add(num); }
            }
            for(int v : oldArrayList){
                System.out.print(v+" ");
            }
            System.out.println("");
            for(int v : evenArrayList){
                System.out.print(v+" ");
            }
            System.out.println("");
        }

    }

}
