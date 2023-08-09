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
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int count = 0;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        while(count < testCases){
            int size = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
              list.add(sc.nextInt());
            }
            map.put(count, list);
            count++;
        }

        for (Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
            printOddValues(entry.getValue());
            printEvenValues(entry.getValue());

        }


    }
    public static void printOddValues(ArrayList<Integer> ls){
        for(int val : ls){
            if(val%2!=0){
                System.out.print(val+" ");
            }
        }
        System.out.println("\b");
    }

    public static void printEvenValues(ArrayList<Integer> ls){
        for(int val : ls){
            if( val % 2 ==0){
                System.out.print(val+" ");
            }
        }
        System.out.println("\b");
    }
}
