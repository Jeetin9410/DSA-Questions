package old.Jan.TwoPointerApproach;

public class MergeTwoSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        int[] a ={1,3,5,7};
        int[] b ={0,2,6,8,9};

        int n = a.length;
        int m = b.length;
        int i = 0;
        while(i < n) {
            if(a[i] > b[0]) {
                int temp = a[i];
                a[i] = b[0];
                b[0] = temp;

                int temp1 = b[0];
                int k = 1;

                while(k < m && temp1 > b[k]) {
                    b[k-1] = b[k];
                    k++;
                }
                b[k-1] = temp1;
            }
            i++;
        }
    }
}
