package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        val happyList = mutableListOf<Int>()
        var list = sadArray.toMutableList()
        for (i in list.indices) {
            for (i in list.indices) {
                if (i != 0 && i != list.lastIndex) {
                    if (list[i] < list[i - 1] + list[i + 1]) {
                        happyList.add(list[i])
                    }
                } else {
                    happyList.add(list[i])
                }
            }
            list.clear()
            list.addAll(happyList)
            happyList.clear()
        }
        return list.toIntArray()


    }
}
