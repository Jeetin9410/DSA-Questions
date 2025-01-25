package DailyLeetCode2025.Jan.TwoPointerApproach;

import java.util.ArrayList;

public class UnionOfTwoSortedArraysWithDuplicates {
    public static void main(String[] args) {

    }
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int n = a.length;
        int m = b.length;
        int i =0;
        int j =0;

        while(i < n && j< m) {

            if(i > 0 && a[i-1] == a[i]) {
                i++;
                continue;
            }

            if(j > 0 && b[j-1] == b[j]) {
                j++;
                continue;
            }

            if(a[i] == b[j]) {
                ans.add(a[i]);
                i++;
                j++;
            } else if(a[i] < b[j]) {
                ans.add(a[i]);
                i++;
            } else {
                ans.add(b[j]);
                j++;
            }
        }

        while(i < n) {

            if(i > 0 && a[i-1] == a[i]) {
                i++;
                continue;
            }
            ans.add(a[i]);
            i++;
        }

        while(j < m) {
            if(j > 0 && b[j-1] == b[j]) {
                j++;
                continue;
            }
            ans.add(b[j]);
            j++;
        }
        return ans;
    }
}
