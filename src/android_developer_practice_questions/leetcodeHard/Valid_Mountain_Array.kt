package android_developer_practice_questions.leetcodeHard

fun main(){
    val arr = intArrayOf(0,2,3,3,5,2,1,0)
                        /* 1,2,3,4,5,6,7,8
                         8,7,6,5,4,3,2,1 */
    println(findPivotPoint(arr))
}
 fun findPivotPoint(array: IntArray) : Int {

     var s = 0;
     var e = array.size-1
     var mid = s + (e - s) / 2
     while(s<e){
        if(array[mid] < array[mid + 1]){
            s = mid + 1;
        }else{
            e = mid -1;
        }
         mid = s + (e - s) / 2
     }
     return mid;
 }