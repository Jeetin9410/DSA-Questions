package old.AdvanceLevelQuestions.StringManipulationsWithHashmap

fun main() {
    val str = "abcabcbb"

    println(longestSubstringWithoutRepeat(str))
}

/*  First try

Error in this : When you update s to map[A[e]]!! + 1, you might accidentally move s backward
                if the repeating character's previous index is less than the current value of s.
                This would result in an incorrect substring length being calculated.

fun longestSubstringWithoutRepeat(string: String) : Int {
    var s = 0
    var e = 0
    val n = string.length
    val map = mutableMapOf<Char,Int>() // char , index
    var max = 0
    while(e < n) {
        if(map.containsKey(string[e])) {
            s = map.get(string[e])!! + 1 // index
        }

        map[string[e]] = e
        max = Math.max(max,(e - s) + 1)
        e++

    }

    return max
}*/


fun longestSubstringWithoutRepeat(string: String) : Int {
    var s = 0
    var e = 0
    val n = string.length
    val map = mutableMapOf<Char,Int>() // char , index
    var max = 0
    while(e < n) {
        if(map.containsKey(string[e])) {
            s = maxOf(s, map[string[e]]!! + 1)  // index
        }

        map[string[e]] = e
        max = Math.max(max,(e - s) + 1)
        e++

    }

    return max
}