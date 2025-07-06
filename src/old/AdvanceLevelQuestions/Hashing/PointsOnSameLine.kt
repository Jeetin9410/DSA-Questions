package old.AdvanceLevelQuestions.Hashing

fun main() {

}

fun solve(A: IntArray, B: IntArray): Int {
    // Idea: All the point that lies on a line will have same slope(m) from (0,0)
    // Will store slope to no of points on it in a map.

    val map = hashMapOf<Float, Int>()
    val len = A.size
    var ans = 0
    for(i in 0 until len) {
        val slope = if(B[i] != 0) (A[i] / B[i]).toFloat() else 0.toFloat();
        val count = map.getOrDefault(slope, 0) + 1
        ans = Math.max(count,ans)
        map.put(slope, count);
    }

    return ans
}