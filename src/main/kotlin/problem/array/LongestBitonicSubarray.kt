package problem.array

// Find the subarray of a given sequence in which the subarray’s elements are first sorted
// in increasing order, then in decreasing order, and the subarray is as long as possible.
// Complexity time/space: O(n)/O(1)
fun longestBitonicSubarray(array: IntArray): Int {
    if (array.isEmpty()) return 0

    var maxLength = 1
    var i = 0
    while (i + 1 in array.indices) {
        var len = 1

        // run till sequence is increasing
        while (i + 1 in array.indices && array[i] < array[i + 1]) {
            i++
            len++
        }
        // run till sequence is decreasing
        while (i + 1 in array.indices && array[i] > array[i + 1]) {
            i++
            len++
        }
        // run till sequence is equal
        while (i + 1 in array.indices && array[i] == array[i + 1]) i++

        maxLength = maxLength.coerceAtLeast(len)
    }

    return maxLength
}
