package old.AdvanceLevelQuestions.BitManipulation;

public class SmallestXOR_scaler {
    /*
    Problem Description
Given two integers A and B, find a number X such that A xor X is minimum possible,
 and the number of set bits in X equals B.



Problem Constraints
0 <= A <= 109
0 <= B <= 30



Input Format
First argument contains a single integer A. Second argument contains a single integer B.



Output Format
Return a single integer X.



Example Input
Input 1:
 A = 3
 B = 3

Input 2:
 A = 15
 B = 2


Example Output
Output 1:    7
Output 2:   12


Example Explanation 1:  3 xor 7 = 4 which is minimum
Explanation 2: 15 xor 12 = 3 which is minimum
     */
    public static void main(String[] args) {

        /*
        Intution :

        to minimise A^X , bits of both numbers should be exact same.

         case1: if no of set bit in X are same as B, return X
         case2: if(no of set bit in X < B)  then toggle the first unsetbit.
                if(no of setbit in X > B)   then toggle the first setbit.


         */

       int A = 4;
       int B = 6;
       int X= A;

        // count set bit in A
         // Using kernighan algorithm

        int countOnes = 0;

        while(A!=0){
            int rsbm = A & -A;
            A=A-rsbm;
            countOnes++;
        }

        if(countOnes == B){
            System.out.println(A);
        }else if(countOnes > B){
            int diff = countOnes - B;

            while(diff!=0){
                int rsbm = X & -X;
                X = X-rsbm;
                diff--;
            }
            System.out.println(X);
        } else if (countOnes < B) {
            int diff = B - countOnes;

                int i=0;
                while(i<32){
                    if((X & (1<<i))==0){
                        X = X | (1<<i);
                        diff--;
                    }
                    i++;
                    if(diff==0){
                        break;
                    }

                }


            System.out.println(X);
        }

        //System.out.println(countOnes);





    }
}
