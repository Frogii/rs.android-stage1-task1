package subtask2

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {

        // создать лист с суммами и найти мин и макс
        var list = mutableListOf<Int>()
        var outputList = mutableListOf<Int>()
        val summ = input.sum()
        for (i in input) {
            var num = summ - i
            list.add(num)
        }
        list.sort()
        outputList.add(list.first())
        outputList.add(list.last())

        return outputList.toIntArray()

    }
}
