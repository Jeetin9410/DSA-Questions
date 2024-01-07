package android_developer_practice_questions.leetcodeHard

fun main(){

    val arr = intArrayOf(7,1,15,11)

    println(checkIfExist(arr))


}

fun checkIfExist(arr: IntArray): Boolean {
    val map = mutableMapOf<Int,Int>()

    arr.forEachIndexed { index, value ->
        if(map.isEmpty()){
            map.put(index,value)
        }else {

            if (map.containsValue(value * 2) || ( value % 2 ==0 && map.containsValue(value / 2 ) )) {
                return true
            } else {
                map.put(index, value)
            }
        }
    }

    return false
}