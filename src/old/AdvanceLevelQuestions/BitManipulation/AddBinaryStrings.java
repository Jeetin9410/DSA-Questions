package old.AdvanceLevelQuestions.BitManipulation;

public class AddBinaryStrings {
    /*
    Given two binary strings A and B. Return their sum (also a binary string).

    1 <= length of A <= 105

    1 <= length of B <= 105

    A and B are binary strings.

    Example Input
    Input 1:
    A = "100"
    B = "11"
    Input 2:
    A = "110"
    B = "10"


    Example Output
    Output 1:
    "111"
    Output 2:
    "1000"
     */
    public static void main(String[] args) {

            String A = "11";
            String B = "1";

            int i = A.length()-1;
            int j = B.length()-1;

            StringBuilder sb = new StringBuilder();

            int carry = 0;

            while (i>=0 ||  j>=0){
                int sum = 0;
                int a = (i < 0)?0:Integer.parseInt(String.valueOf(A.charAt(i)));
                int b = (j < 0)?0:Integer.parseInt(String.valueOf(B.charAt(j)));

                sum = a + b + carry;

                if(sum > 1){
                    carry = 1;
                    sum =0;
                    sb.append(sum);
                    System.out.println(a+" "+b+" "+sum);
                }else{
                    sb.append(sum);
                    carry = 0;
                    System.out.println(a+" "+b+" "+sum);
                }
                i--;
                j--;
            }

            if(carry==1){
                sb.append(1);
            }

        System.out.println(sb.reverse().toString());
    }
}
