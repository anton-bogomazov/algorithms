package algorithm.sort

// Main idea: count elements frequencies and construct sorted array from histogram.
// Worst case complexity time/space: O(n)/O(n)
fun countingSort(array: Array<Int>) {
    val freqSize = array.max() + 1
    val freq = IntArray(freqSize)

    // count all array values
    for (i in array) {
        freq[i]++
    }

    // overwrite the input array with sorted order
    var index = 0
    for (i in freq.indices) {
        while (freq[i]-- > 0) {
            array[index++] = i
        }
    }
}
