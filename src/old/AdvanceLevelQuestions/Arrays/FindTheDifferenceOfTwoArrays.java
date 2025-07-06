package old.AdvanceLevelQuestions.Arrays;


import java.util.*;
public class FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {

        int[] nums1= {1,2,3};
        int[] nums2 = {2,4,6};

        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        for(int i : nums1){
            set1.add(i);
        }

        for(int i : nums2){
            set2.add(i);
        }

        for(int i : set1){
            if(set2.contains(i) == false){
                list1.add(i);
            }
        }

        for(int i : set2){
            if(set1.contains(i) == false){
                list2.add(i);
            }
        }

        ans.add(list1);
        ans.add(list2);

        for (List<Integer> i : ans){
            System.out.println(Arrays.toString(i.toArray()));
        }




    }
}
