package problem.solving

import kotlin.math.max

// aka Kadane’s Algorithm
// Given an integer array, find a contiguous subarray within it that has the largest sum.

// Complexity time/space: O(n)/O(1)
fun findMaxSumSubarray(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var maxSum = Integer.MIN_VALUE
    var tempSum = 0

    for (num in nums) {
        tempSum = max(tempSum + num, num)
        maxSum = max(maxSum, tempSum)
    }

    return maxSum
}
