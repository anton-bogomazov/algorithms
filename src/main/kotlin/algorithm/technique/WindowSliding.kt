package algorithm.technique

// Reduce nested loop by moving fix-sized 'window'

// Given an array of integers of size ‘n’.
// Calculate the maximum sum of ‘k’ consecutive elements in the array.
// Complexity time/space: O(n)/O(1)
fun maxSumWindowSliding(arr: IntArray, n: Int, k: Int): Int {
    var maxSum = 0
    for (i in 0 until k) maxSum += arr[i]

    var windowSum = maxSum
    for (i in k until n) {
        windowSum += arr[i] - arr[i - k]
        maxSum = maxSum.coerceAtLeast(windowSum)
    }

    return maxSum
}
