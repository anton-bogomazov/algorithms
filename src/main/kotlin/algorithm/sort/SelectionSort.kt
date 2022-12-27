package algorithm.sort

// Main idea: pick the smallest element from unsorted subarray.
// Worst case complexity time/space: O(n2)/O(1)
fun selectionSort(array: Array<Int>) {
    for (i in array.indices) {
        var minIndex = i

        // iterate over the unsorted elements and find the minimum
        for (j in (i + 1)..array.lastIndex) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }

        // swap with current element
        val temp = array[i]
        array[i] = array[minIndex]
        array[minIndex] = temp
    }
}
