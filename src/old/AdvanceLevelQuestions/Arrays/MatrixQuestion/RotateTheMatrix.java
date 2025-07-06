package old.AdvanceLevelQuestions.Arrays.MatrixQuestion;

public class RotateTheMatrix {
    /*
    Given a square matrix,
    the task is that turn it by 180 degrees in an anti-clockwise direction without using any extra space.

    Input :  1  2  3
            4  5  6
            7  8  9
    Output : 9 8 7
            6 5 4
            3 2 1

    Input :  1 2 3 4
            5 6 7 8
            9 0 1 2
            3 4 5 6
    Output : 6 5 4 3
            2 1 0 9
            8 7 6 5
            4 3 2 1
     */

    public static void main(String[] args) {

        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,0,1,2},{3,4,5,6}};

        for(int i = arr.length-1; i>=0;i--){
            for(int j = arr[0].length-1;j>=0;j--){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
