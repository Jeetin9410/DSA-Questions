package old.AdvanceLevelQuestions.Recursion;

import java.util.ArrayList;

public class N_Bit_Gray_Code {
    public static void main(String[] args) {
        /// Explained in notebook

        ArrayList<String> ans = grayCode(3);

        for (String s:ans) {
            System.out.println(s);
        }

    }
    public static ArrayList<String> grayCode(int N){
        if(N==1){
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("0");
            baseResult.add("1");
            return baseResult;
        }

        ArrayList<String> tempResult = grayCode(N-1);
        ArrayList<String> finalResult = new ArrayList<>();

        for (int i =0;i<tempResult.size();i++){
            finalResult.add("0"+tempResult.get(i));
        }

        for(int i = tempResult.size()-1;i>=0;i--){
            finalResult.add("1"+tempResult.get(i));
        }
        return finalResult;
    }
}
