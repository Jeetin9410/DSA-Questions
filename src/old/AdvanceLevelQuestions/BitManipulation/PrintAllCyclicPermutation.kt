package old.AdvanceLevelQuestions.BitManipulation

fun main() {
    /*
     For a given binary String, print all cyclic permutations of it.
        Ex: A = "1101"
        Ans :  "1101"
               "1011"
               "0111"
               "1110"
     */
    val A = "1101"

    /* Concept :

    By concatenating B with itself to create A2 = A + A,
    you can represent all possible cyclic shifts of A as contiguous substrings of length n within A2.

    B2 = B + B = "11011101"

    Now, all possible cyclic shifts of B appear as substrings in B2:

    "1101" → starting at index 0
    "1011" → starting at index 1
    "0111" → starting at index 2
    "1110" → starting at index 3

     */

    val A2 = A + A

    val n = A.length

    for( i in 0 until n){
        println(A2.substring(i,i+n))
    }

}