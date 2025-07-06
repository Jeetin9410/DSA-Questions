package old.AdvanceLevelQuestions.BitManipulation;

public class MinimizeXOR {
    /* leetcode 2429

    Given two positive integers num1 and num2, find the positive integer x such that:

    1. x has the same number of set bits as num2, and
    2. The value x XOR num1 is minimal.
    Note that XOR is the bitwise XOR operation.

    Return the integer x. The test cases are generated such that x is uniquely determined.

    The number of set bits of an integer is the number of 1's in its binary representation.



    Example 1:

    Input: num1 = 3, num2 = 5
    Output: 3
    Explanation:
    The binary representations of num1 and num2 are 0011 and 0101, respectively.
    The integer 3 has the same number of set bits as num2, and the value 3 XOR 3 = 0 is minimal.
    Example 2:

    Input: num1 = 1, num2 = 12
    Output: 3
    Explanation:
    The binary representations of num1 and num2 are 0001 and 1100, respectively.
    The integer 3 has the same number of set bits as num2, and the value 3 XOR 1 = 2 is minimal.

     */

    public static void main(String[] args) {
        int num1 = 2;
        int num2 = 3;

        /*  num1 = 2 = 0010
            num2 = 3 = 0011

            XOR of a and b two bit is 1, if bits different and 0 when bits are same.

            To minimise th XOR of x with (2 set bits) with 0010 -->
            we need to make all 1 bits to 0....means
            For example:

        (Index) 0 1 2 3
                0 0 1 0

                the first set bit is on 2nd index so..from left to right we will try to change them to 0 , using zor

                which also means ke we will iterate from left to right in 32bit for loop in num1
                and will we set every 1 bit to zero by making it xor with 1.

                and in second for loop we will iterate from right to left side,an will change every 0 bit to 1 again
                using 1 , remaining 1.

                and the resulting number will be our answer

                for num1 = 2 = 0 0 1 0
                 we have 2 (1 bits)

                so first bit we will use for index 2 and remaining at index 3

                so x = 0011

                Ans is 3 itself

         */

        // So first we need to find total number of setBit in num2

        int totalSetBit = Integer.bitCount(num2);

        for(int i =0; i<32; i++) {
            System.out.print((num2 >> i) & 1);
        }
        System.out.println();
        for(int i = 31; i>=0; i--) {
            System.out.print((num2 >> i) & 1);
        }
    }
}
