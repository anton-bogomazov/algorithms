package problem.longest

import kotlin.math.max

// Find the longest subsequences of a string that's also a palindrome.
// Complexity time/space: O(n2)/O(n2)
fun longestPalindromicSubsequence(str: String) =
    rec(str, 0, str.lastIndex, Array(str.length) { IntArray(str.length) { -1 } })

private fun rec(str: String, i: Int, j: Int, dp: Array<IntArray>): Int {
    // Base Case 1: If there is only 1 character
    if (i == j) {
        return 1.also { dp[i][j] = it }
    }
    // Base Case 2: If there are only 2 characters and both are same
    if (str[i] == str[j] && i + 1 == j) {
        return 2.also { dp[i][j] = it }
    }
    // Avoid extra call for already calculated subproblems, Just return the saved answer from cache
    if (dp[i][j] != -1) return dp[i][j]
    // If the first and last characters match
    return if (str[i] == str[j]) {
        rec(str, i + 1, j - 1, dp) + 2.also { dp[i][j] = it }
    } else {
        max(rec(str, i, j - 1, dp), rec(str, i + 1, j, dp)).also { dp[i][j] = it }
    }
}
