package old.AdvanceLevelQuestions.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LargestNumber {
    /*
    Given an array A of non-negative integers, arrange them such that they form the largest number.

    Note: The result may be very large, so you need to return a string instead of an integer.

    1 <= len(A) <= 100000
    0 <= A[i] <= 2*10^9

    Example Input
Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output
Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation
Explanation 1:

Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
     */
    public static void main(String[] args) {
        int[] A = {9, 5, 34, 3, 30};


        //  First intution

        /*
           we will map the given elements on the basis og first digit of given number.
           then combine number starting from highest key to lowerst key
           and joining those numbers to form a string.
         */

     /*   HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i<A.length;i++){
            if(A[i] > 0){
                if(A[i] > 9){
                    int firstDigit = findFirstDigitOfNumber(A[i]);
                    if(map.containsKey(firstDigit)){
                        ArrayList<Integer> ls = map.get(firstDigit);
                        ls.add(A[i]);
                        map.put(firstDigit,ls);
                    }else{
                        ArrayList<Integer> ls = new ArrayList<>();
                        ls.add(A[i]);
                        map.put(firstDigit,ls);
                    }
                }else{
                    if(map.containsKey(A[i])){
                        ArrayList<Integer> ls = map.get(A[i]);
                        ls.add(A[i]);
                        map.put(A[i],ls);
                    }else{
                        ArrayList<Integer> ls = new ArrayList<>();
                        ls.add(A[i]);
                        map.put(A[i],ls);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if(map.isEmpty()){
            sb.append("0");     // edge case
        }else{

            /// before swapping elements
            for (Integer name: map.keySet()) {
                String key = name.toString();
                String value = map.get(name).toString();
                System.out.println(key + " " + value);
            }


            for(Integer digit : map.keySet()){
                ArrayList<Integer> ls = map.get(digit);
                if(ls.contains(digit) && ls.contains(digit*10)){
                    for(int i=0;i< ls.size();i++){
                        if(ls.get(i) == digit){
                            for(int j =i+1; j<ls.size();j++){
                                if(ls.get(j)/digit == 10){
                                    Collections.swap(ls,i,j);
                                }
                            }
                        }
                    }
                }
            }
            /// after swapping elements
        for (Integer name: map.keySet()) {
            String key = name.toString();
            String value = map.get(name).toString();
            System.out.println(key + " " + value);
        }

          //  StringBuilder sb = new StringBuilder();


            ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
            for(int i=keys.size()-1; i>=0;i--){
                ArrayList<Integer> ls= map.get(keys.get(i));
                Collections.reverse(ls);
                if(ls.size()==1){
                    sb.append(ls.get(0));
                }else{
                    for(Integer val : ls){
                        sb.append(val);
                    }
                }
            }

        }

        System.out.println(sb.toString());
        */




        ////// Second Intuition

        /*
           let us first sort the given array in decreasing order
           Exam : A =  3,30,34,5,9
           sort(A) ==> 34,30,9,5,3

           now to form the highest number possible, we have to sort the array on the basis of onces digit of every number

           then this array will look like this : 9,5,34,3,30 ===> which eventually is the answer as well



         */

        Arrays.sort(A);
        // step 1 :  first finding the index after which double digit numbers are starting
        int index = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] > 9){
                index = i-1;
                break;
            }
        }

        for(int i = 0; i<=index;i++){
            for(int j =index+1;j< A.length;j++){
                int lastDigit = findLastDigitOfNumber(A[j]);
                if(lastDigit > A[i]){

                }
            }
        }



    }
    public static int findLastDigitOfNumber(int num){
        String s = String.valueOf(num);
        int last_digit = s.charAt(s.length()-1) - '0';
        return last_digit;
    }


}
