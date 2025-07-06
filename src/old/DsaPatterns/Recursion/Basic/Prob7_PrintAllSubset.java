package old.DsaPatterns.Recursion.Basic;

import java.util.ArrayList;
import java.util.List;

public class Prob7_PrintAllSubset {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        generateSubsets(arr, 0,current , result);

        //System.out.println(result.toString());
    }
    public static void generateSubsets(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        if(index == arr.length) {
            result.add(new ArrayList<>(current));
            System.out.println(current.toString());
            return;
        }

        current.add(arr[index]);
        generateSubsets(arr,index + 1, current, result);

        current.remove(current.size() - 1);
        generateSubsets(arr, index + 1, current, result);

        /*current.add(arr[index]);
        generateSubsets(arr,index + 1, current, result);*/
    }
}
