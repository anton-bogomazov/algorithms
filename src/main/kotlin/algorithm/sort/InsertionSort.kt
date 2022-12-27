package algorithm.sort

// Main idea: insert next element to correct position.
// Worst case complexity time/space: O(n2)/O(1)
fun insertionsSort(array: Array<Int>) {
    for (i in 1..array.lastIndex) {
        val elementToInsert = array[i]
        var currentPosition = i - 1

        // shift right while in bounds and elementToInsert is less than current element
        while (currentPosition >= 0 && array[currentPosition] > elementToInsert) {
            array[currentPosition + 1] = array[currentPosition]
            currentPosition--
        }

        array[currentPosition + 1] = elementToInsert
    }
}
