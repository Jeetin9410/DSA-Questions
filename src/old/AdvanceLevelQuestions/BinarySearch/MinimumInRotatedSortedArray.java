package old.AdvanceLevelQuestions.BinarySearch;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {11,12,15,18,2,5,6,8};

        int s = 0;
        int e = arr.length - 1;

        while (s < e) {
            int mid = s + (e - s)/2;
            if(arr[mid] < arr[e]) { // the minimum element will always be on unsorted side of mid,
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        System.out.println("index "+ s+ " , element "+ arr[s]);
    }
}
