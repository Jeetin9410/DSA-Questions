package old.AdvanceLevelQuestions.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9};
        int key = 5;
        System.out.println(BinarySearch(A,key));
    }
    public static int BinarySearch(int[] A, int key){
        int s= 0;
        int e= A.length-1;

        while(s<=e){
            int mid = s + (e-s)/2;
            if(key == A[mid])
                return mid;
            else if(key < A[mid]){
                e = mid -1;
            }else{
                s = mid + 1;
            }
        }
        return -1;
    }
}
