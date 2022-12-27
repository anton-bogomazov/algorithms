package algorithm.sort

// Main idea: swap adjacent values if first greater than second.
// Worst case complexity time/space: O(n2)/O(1)
fun bubbleSort(array: Array<Int>) {
    for (i in array.indices) {
        for (j in (0 until (array.lastIndex - i))) {
            if (array[j] > array[j + 1]) {
                val temp = array[j + 1]
                array[j + 1] = array[j]
                array[j] = temp
            }
        }
    }
}
