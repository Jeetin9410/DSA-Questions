package old.AdvanceLevelQuestions.Arrays.MatrixQuestion
/*
Given an m x n matrix, return all elements of the matrix in spiral order.

link: https://leetcode.com/problems/spiral-matrix/description/

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

*/
fun main() {

    //given matrix:
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

    /*
    We will take 4 variable to initially mark points on matrix
    i.e top , bottom, left and right,
    top = 0,
    bottom = matrix.size - 1
    left = 0
    right = matrix[0].size - 1
    loop till (top <= bottom && left <= right)


     */

    val result = mutableListOf<Int>()
    if (matrix.isEmpty()) return println(result);

    var top = 0
    var bottom = matrix.size - 1
    var left = 0
    var right = matrix[0].size - 1

    while (top <= bottom && left <= right) {
        // Traverse from left to right along the top row
        for (i in left..right) {
            result.add(matrix[top][i])
        }
        top++

        // Traverse from top to bottom along the right column
        for (i in top..bottom) {
            result.add(matrix[i][right])
        }
        right--

        // Check if there's still a row left to traverse from right to left
        if (top <= bottom) {
            for (i in right downTo left) {
                result.add(matrix[bottom][i])
            }
            bottom--
        }

        // Check if there's still a column left to traverse from bottom to top
        if (left <= right) {
            for (i in bottom downTo top) {
                result.add(matrix[i][left])
            }
            left++
        }
    }

    println(result.toString());

}