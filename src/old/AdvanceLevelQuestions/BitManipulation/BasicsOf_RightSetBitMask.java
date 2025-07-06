package old.AdvanceLevelQuestions.BitManipulation;

public class BasicsOf_RightSetBitMask {
    /*
    Find the Right set bit mask of given Number N.
     */

    public static void main(String[] args) {
        /*
        Right Set Bit mask : A  binary number where only the right most set bit is 1 all other bits are 0;
        Example
        x = 57 ==> .......(26 0's)....1 1 1 0 0 1
        its rsbm == ......(26 0's)....0 0 0 0 0 1

        x = 76 ==>....................1 0 0 1 1 0 0
        rsbm==>   ....................0 0 0 0 1 0 0

         concept :  Rsbm of any number is : x & x''(2's compliment of x)
                                                OR
                                   rsbm : (x & -x)


         */

        int x = 76;

        System.out.println("Right Set Bit Mask" + Integer.toBinaryString(x & -x));
    }
}
