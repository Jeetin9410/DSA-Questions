package old.DsaPatterns.Recursion

/*                          Integer to English Words

Convert a non-negative integer num to its English words representation.



Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"
Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"


Constraints:

0 <= num <= 2^31 - 1


 */


//Solution
val digits = arrayOf("Zero", "One", "Two", "Three", "Four", "Five","Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen","Nineteen")
val tens = arrayOf("","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety")

fun main() {
    val num = 110500
    println(numberToWords(num))
}

fun numberToWords(num: Int) : String {
    if(num == 0) {
        return "Zero"
    }

    return solve(num)
}

fun solve(num: Int): String {
    if (num < 10) {
        return digits[num]
    }

    if (num < 20) {
        return digits[num]
    }

    if (num < 100) {
        return tens[num / 10] + (if (num % 10 == 0) "" else (" " + digits[num % 10]))
    }

    if (num < 1000) {
        return digits[num / 100] + " Hundred" + if (num % 100 == 0) "" else " " + solve(num % 100)
    }

    if (num < 1000000) {
        return solve(num / 1000) + " Thousand" + if (num % 1000 == 0) "" else " " + solve(num % 1000)
    }

    if (num < 1000000000) {
        return solve(num / 1000000) + " Million" + if (num % 1000000 == 0) "" else " " + solve(num % 1000000)
    }

    return solve(num / 1000000000) + " Billion" + if (num % 1000000000 == 0) "" else " " + solve(num % 1000000000)
}