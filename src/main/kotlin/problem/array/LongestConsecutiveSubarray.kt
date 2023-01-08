package problem.array

import kotlin.math.max
import kotlin.math.min

// Find the largest subarray formed by consecutive integers.
// The subarray should contain all distinct values.
// Complexity time/space: O(n2)/O(1)
fun longestConsecutiveSubarray(array: Array<Int>): Int {
    var maxLength = 1 // Initialize result

    for (i in array.indices) {
        // Initialize min and max for all subarrays starting with i
        var min = array[i]
        var max = array[i]

        // Consider all subarrays starting with i and ending with j
        for (j in i + 1..array.lastIndex) {
            // Update min and max in this subarray if needed
            min = min(min, array[j])
            max = max(max, array[j])

            // If current subarray has all contiguous elements
            if (max - min == j - i) maxLength = max(maxLength, max - min + 1)
        }
    }

    return maxLength
}
