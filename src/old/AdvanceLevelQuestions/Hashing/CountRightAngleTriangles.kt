package old.AdvanceLevelQuestions.Hashing

/*                  Scaler Hashing Advance question

Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N
represents a unique point (x, y) in 2D Cartesian plane.

Find and return the number of unordered triplets (i, j, k) such that
(A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle with the triangle
having one side parallel to the x-axis and one side parallel to the y-axis. ===> Important Part.

NOTE: The answer may be large so return the answer modulo (10^9 + 7).

Problem Constraints
1 <= N <= 105

0 <= A[i], B[i] <= 109



Input Format
The first argument given is an integer array A.
The second argument given is the integer array B.



Output Format
Return the number of unordered triplets that form a right angled triangle modulo (109 + 7).



Example Input
Input 1:

 A = [1, 1, 2]
 B = [1, 2, 1]
Input 2:

 A = [1, 1, 2, 3, 3]
 B = [1, 2, 1, 2, 1]


Example Output
Output 1:

 1
Output 2:

 6



*/

fun main() {
    val A = intArrayOf(1, 1, 2, 3, 3)
    val B = intArrayOf(1, 2, 1, 2, 1)

    /*
    Requirement :
    1. rightAngleTriangle with sides parallel to x and y axis

            P(x1,y1)
            |
            |
            |
            |
            |
            |
     Q(x2,y2)--------------------- R(x3, y3)

     Suppose this triangle is parallel to x and y-axis both,  can you find any connection between P, Q and R now?

        Ans: For PQR to be a right angle triangle,
                => P.x1 == Q.x2 and Q.y2 == R.y3 and then Q will be the pivot point. similarly P  and R can be the pivot



    */

    ///// Method 1  : Brute Force
   /* val MOD = 1000000007
    val n = A.size
    var count = 0L

    // Iterate through all possible triplets (i, j, k)
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            for (k in j + 1 until n) {
                // Check if the points form a right-angled triangle
                if (isRightAngledTriangle(A[i], B[i], A[j], B[j], A[k], B[k])) {
                    count++
                    count %= MOD
                }
            }
        }
    }

    */



    //// Method 2 : Better Approach

    /*
            *
            |
            *
            |
            *
            |
     P(x,y) * -- * -- * -- * -- *

        For Point P(x,y) as Pivot, Total number of right angle triangles possible are

       [ (Total no of points that contains x ) - 1 ] * [ (Total no of points that contains y ) - 1]


     */


    val MOD = 1000000007
    val n = A.size

    val xCount = mutableMapOf<Int, Int>()
    val yCount = mutableMapOf<Int, Int>()

    // Count occurrences of each x and y coordinate
    for (i in 0 until n) {
        xCount[A[i]] = xCount.getOrDefault(A[i], 0) + 1
        yCount[B[i]] = yCount.getOrDefault(B[i], 0) + 1
    }

    var result = 0L

    // Calculate the number of valid triplets
    for (i in 0 until n) {
        val xContribution = xCount[A[i]]!! - 1
        val yContribution = yCount[B[i]]!! - 1
        result += xContribution.toLong() * yContribution.toLong()
        result %= MOD
    }


    print(result.toInt())
}
// Function to check if the given points form a right-angled triangle with one side parallel to the x-axis and one side parallel to the y-axis
fun isRightAngledTriangle(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int): Boolean {
    return (x1 == x2 && y1 == y3) || (x1 == x3 && y1 == y2) ||
            (x2 == x3 && y2 == y1) || (x2 == x1 && y2 == y3) ||
            (x3 == x1 && y3 == y2) || (x3 == x2 && y3 == y1)
}