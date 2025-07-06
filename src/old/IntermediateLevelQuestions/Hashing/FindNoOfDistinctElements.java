package old.IntermediateLevelQuestions.Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class FindNoOfDistinctElements {
    /*
        Given N Array element , find no of distinct elements.

        Ex :
        arr = {3,5,6,5,4};  ans  = {3,5,6,4}

        arr = {6,3,7,3,8,6,9};  ans= {6,3,7,8,9}
     */
    public static void main(String[] args) {
        int[] A = {6,3,7,3,8,6,9};

        HashSet<Integer> set = new HashSet<>();

        for(int i: A){
            set.add(i);
        }

        System.out.println(Arrays.asList(set));
    }
}
