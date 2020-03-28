package subtask4

import java.util.regex.Pattern


class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val result = mutableListOf<String>()
        val subStringsList = mutableListOf<SubString>()
        inputString.toCharArray().mapIndexed { startIndex, char ->
            if (isOpenBracket(char)) {
                subStringsList.add(SubString(char, start=startIndex, end=lastBracketIndex(char, startIndex, inputString)))
            }
        }
        subStringsList.map {
            if (it.end != -1)
                result.add(inputString.substring(it.start + 1, it.end + 1))
        }
        return result.toTypedArray()
    }

    fun isOpenBracket(char: Char) = when (char) {
        '(' -> true
        '[' -> true
        '<' -> true
        else -> false
    }

    fun revertBracket(char: Char) = when (char) {
        '(' -> ')'
        '[' -> ']'
        else -> '>'
    }

    fun lastBracketIndex(startBracket: Char, start: Int, inputString: String): Int {
        var result = -1
        var count = 0
        val revertBracket = revertBracket(startBracket)
        inputString.substring(start + 1).toCharArray().mapIndexed { index, char ->
            if (char == startBracket) {
                count++
            }
            if (char == revertBracket && count == 0) {
                return index + start
            } else if (char == revertBracket && count != 0) {
                count--
            }
        }
        return result + start
    }
}

data class SubString(
    val char: Char,
    val start: Int,
    val end: Int
)


