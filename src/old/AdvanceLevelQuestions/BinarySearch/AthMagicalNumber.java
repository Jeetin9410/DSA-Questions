package old.AdvanceLevelQuestions.BinarySearch;

public class AthMagicalNumber {
    /*
    You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 10^9 + 7.


1 <= A <= 10^9

2 <= B, C <= 40000


Example Input
Input 1:

 A = 1
 B = 2
 C = 3
Input 2:

 A = 4
 B = 2
 C = 3


Example Output
Output 1:

 2
Output 2:

 6


Example Explanation
Explanation 1:

 1st magical number is 2.
Explanation 2:

 First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
     */

    public static void main(String[] args) {
        int A = 14;
        int B = 10;
        int C = 12;
        /* Intution 1 : This approach didnt work throughout
            System.out.println(solve(A,B,C));

         */

        /* Intution 2 :  Using Binary Search
            Q: Search space?
           Observation : all the multiple of B and C combined together in non repeative and increasing order is our search space.

            So low of that search space will be : low = Min(B,C)
            and high  = A*max(B,C)

            These low and high doesnt point to any index , instead they point to numbers itself.

            Q : Now what will be our logic to find Nth smallest element in search space?
            Ans : after mid = (low + high)/2;
                  if we can find how many element are before mid,then we can determine where we have to move either left or right.

                  Q: how to find how amny number are there before x which are divisible by y.
                  Ans : Simple division.
                  Ex :  10 / 2 = 5

                  Q so number divisible by B ==> mid / B
                    and number divisible by C ==> mid / C

                    AND the numbers divisible by both B and C are also got included twice so == > mid / lcm(B,C)  will be substracted from above two equation

         */

        System.out.println(solveII(A,B,C));
    }

    public static int solve(int A, int B, int C){

        int low = 1;
        int high = A;
        // Why like above?
        /*
        Ans : if we carefully observe , we dont have any array , ans we are considering 4 or A multilples of B and C
              so max value high pointer will be 4. and low will be 1.
         */
        int partition = A;

        if(A==1) {
            return Math.min(B, C);
        }

        while(low<=high){
            int cut1 = (low + high)/2;
            int cut2 = partition - cut1;

            int l1 = (cut1==0)?Integer.MIN_VALUE : B*(cut1);
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE:C*(cut2);

            int r1 = (cut1 == A)?Integer.MAX_VALUE : B*(cut1+1);
            int r2 = (cut2 == A)?Integer.MAX_VALUE : C*(cut2+1);

            if(l1<=r2 && l2<=r1){
               return Math.max(l1,l2);
            } else if (l1 > r2) {
                high = cut1 -1;
            }else{
                low = cut1 + 1;
            }
        }
        return -1;
    }

    public static int solveII(int A,int B,int C){
        long mod = 1000000007;
        long low = Math.min(B,C);
        long high = (long)A * Math.max(B,C);


        int hcf = FindHCF(B,C);

        int lcm = B*C / hcf;

        while(low<high){
            long mid = low + (high - low)/2;

            if( ( (mid / B) + (mid / C) - (mid / lcm) ) < A ){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        return (int) (low % mod);
    }

    public static int FindHCF(int a, int b){
        while( a%b!= 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return b;
    }

}
