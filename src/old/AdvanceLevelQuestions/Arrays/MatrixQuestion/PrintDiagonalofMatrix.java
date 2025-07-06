package old.AdvanceLevelQuestions.Arrays.MatrixQuestion;

public class PrintDiagonalofMatrix {
    /*
    Given a 2D square matrix, print the Principal and Secondary diagonals.

    The primary diagonal is formed by the elements A00, A11, A22, A33.
    Condition for Principal Diagonal: The row-column condition is row = column.

    The secondary diagonal is formed by the elements A03, A12, A21, A30.
    Condition for Secondary Diagonal: The row-column condition is row = numberOfRows – column -1.

    Examples :

    Input:
    1 2 3 4
    4 3 2 1
    7 8 9 6
    6 5 4 3
    Output:
    Principal Diagonal: 1, 3, 9, 3
    Secondary Diagonal: 4, 2, 8, 6

    Input:
    1 1 1
    1 1 1
    1 1 1
    Output:
    Principal Diagonal: 1, 1, 1
    Secondary Diagonal: 1, 1, 1
     */

    public static void main(String[] args) {

        int matrix[][] = {{1,2,3,4},{4,3,2,1},{7,8,9,6},{6,5,4,3}};

/*
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length; j++){
                if(i==j){
                    System.out.println(matrix[i][j]);
                }
            }
        }
*/
        // better way for principal diagonal
        System.out.println("Principal Diagonal");
        for(int i =0; i<matrix.length;i++){
            System.out.print(matrix[i][i]+" ");
        }

        System.out.println("\nSecondary Diagonal");

        for(int j = matrix.length -1,k=0; j>=0; j--,k++){
            System.out.print(matrix[k][j]+" ");
        }

    }
}
