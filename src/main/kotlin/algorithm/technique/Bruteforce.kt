package algorithm.technique

// Try all possible combinations of solutions and check which one is correct.

// Given an array of integers of size ‘n’.
// Calculate the maximum sum of ‘k’ consecutive elements in the array.
// Complexity time/space: O(n2)/O(1)
fun maxSumBruteforce(arr: IntArray, n: Int, k: Int): Int {
    var maxSum = Int.MIN_VALUE

    for (i in 0 until n - k + 1) {
        var currentSum = 0
        for (j in 0 until k) currentSum += arr[i + j]

        maxSum = currentSum.coerceAtLeast(maxSum)
    }
    return maxSum
}
