package problem.array

// Find subarray with alternating positive and negative elements,
// and in which the subarray is as long as possible.
// Complexity time/space: O(n)/O(n)
fun longestAlternatingSubarray(nums: Array<Int>): Array<Int> {
    if (nums.isEmpty()) return arrayOf()

    var maxLength = 1
    var currentLength = 1
    var endIndex = 0

    // traverse the given array starting from the second index
    for (i in 1..nums.lastIndex) {
        // if the current element has an opposite sign than the previous element
        if (nums[i] * nums[i - 1] < 0) {
            // include the current element in the longest alternating subarray
            // ending at the previous index
            currentLength++

            // update result if the current subarray length is found to be greater
            if (currentLength > maxLength) {
                maxLength = currentLength
                endIndex = i
            }
        } else {
            currentLength = 1
        }
    }

    return nums.copyOfRange(endIndex - maxLength + 1, endIndex + 1)
}
