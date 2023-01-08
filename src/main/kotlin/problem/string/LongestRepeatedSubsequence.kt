package problem.string

import kotlin.math.max

// Find the longest subsequences of a string that occurs at least twice.
// Complexity time/space: O(n2)/O(n2)
fun longestRepeatedSubsequence(string: String): Int {
    return rec(string, string.length, string.length, mutableMapOf())
}

private fun rec(string: String, i: Int, j: Int, lookupMap: MutableMap<String, Int>): Int {
    if (i == 0 || j == 0) return 0

    val key = "$i|$j"
    if (lookupMap.contains(key)) return lookupMap[key]!!

    val result = if (i != j && string[i - 1] == string[j - 1]) {
        rec(string, i - 1, j - 1, lookupMap) + 1
    } else max(rec(string, i, j - 1, lookupMap), rec(string, i - 1, j, lookupMap))

    lookupMap[key] = result

    return result
}
