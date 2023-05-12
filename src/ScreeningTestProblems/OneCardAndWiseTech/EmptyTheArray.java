package ScreeningTestProblems.OneCardAndWiseTech;

import java.util.*;
public class EmptyTheArray {
    /*
    Given an even size array, we can perform any operation on the array,
    until the array becomes empty such that the overall cost should be minimum.

Operations:

remove first and last element => cost will be gcd(first, last)
remove first and middle element => cost will be gcd(first, middle)
remove middle and last element => cost will be gcd(middle, last)


Example:

Input: [2, 4, 8, 6]

Output: 4

Explanation:

In the first operation remove the first and middle element, cost = gcd(2,8) = 2
In the second operation remove 4 and 6, cost = gcd(4,6) = 2
Total cost = 2+2 = 4

     */
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2,4,6,8));

        int cost = 0;

        while(list.size()!=0){
            int firstLast = gcd(list.get(0),list.get(list.size()-1)); //a
            int firstMiddle = gcd(list.get(0),list.get((list.size())/2)); //b
            int middleLast = gcd(list.get((list.size())/2),list.get(list.size()-1)); //c

            if(firstLast < firstMiddle && firstLast < middleLast)
            {
                System.out.println(list.get(0)+" f "+list.get(list.size()-1));
               list.remove(0);
               list.remove(list.size()-1);
               cost += firstLast;
            }
            else if(firstMiddle < middleLast)
            {
                System.out.println(list.get(0)+" s "+list.get((list.size()-1)/2));
                list.remove(0);
                list.remove((list.size()-1)/2);
                cost += firstMiddle;
            }
            else
            {
                System.out.println(list.get((list.size()-1)/2)+" t "+list.get(list.size()-1));
                list.remove((list.size()-1)/2);
                list.remove(list.size()-1);
                cost += middleLast;
            }
        }

        System.out.println(cost);

    }
    public static int gcd(int a,int b){

        while(a%b!=0){
            int rem = a%b;
            a = b;
            b = rem;
        }
        return b;
    }
}
