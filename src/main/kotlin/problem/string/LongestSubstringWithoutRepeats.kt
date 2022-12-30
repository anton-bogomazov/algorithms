package problem.string

// Find the length of the longest substring without repeating characters.
// Complexity time/space: O(n)/O(m)

private const val asciiPower = 128

fun longestSubstringWithoutRepeats(str: String): Int {
    val chars = arrayOfNulls<Int>(asciiPower)

    var result = 0
    var left = 0

    for (right in str.indices) {
        val symbol = str[right]
        val index = chars[symbol.code]
        if (index != null && index >= left && index < right) {
            left = index + 1
        }
        result = result.coerceAtLeast(right - left + 1)
        chars[symbol.code] = right
    }

    return result
}
