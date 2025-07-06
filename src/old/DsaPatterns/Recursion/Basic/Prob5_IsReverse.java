package old.DsaPatterns.Recursion.Basic;

public class Prob5_IsReverse {
    /*
    You are given two strings str1 and str2 and you have to return true if str2 is reverse of str1,
    otherwise return false.
    */

    public static void main(String[] args) {
        String str1 = "cat";
        String str2 = "tacx";
        System.out.println(isReverse(str1, str2));
    }

    public static boolean isReverse(String str1, String str2) {
        if(str1.isEmpty() && str2.isEmpty()) {
            return true;
        }

        if(str1.length() != str2.length()) {
            return false;
        }

        String first = str1.substring(0,1);
        String last = str2.substring(str2.length()-1);

        return first.equals(last) && isReverse(str1.substring(1), str2.substring(0, str2.length() -1));
    }
}
