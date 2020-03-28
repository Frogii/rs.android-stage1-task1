package subtask5

import java.util.*

class HighestPalindrome {

    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val chArr = digitString.toCharArray()
        var count = 0
        for (index in chArr.indices) {
            if (index > chArr.size / 2) break

            if (chArr[index] != chArr[chArr.size - index - 1]) {
                if (chArr[index] == '0') {
                    chArr[index] = '9'
                }
                chArr[chArr.size - index - 1] = chArr[index]
                count++
            } else if (count > k) {
                return "-1"
            }
        }
        return String(chArr)
    }
}

