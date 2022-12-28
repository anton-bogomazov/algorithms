package algorithm.string

// Knuth, Morris, and Pratt String Searching Algorithm
// Return a list of indices where the text matches the pattern.
// Worst case complexity time/space: O(m + n)/O(1)
fun kmpSearch(text: String, pattern: String): List<Int> {
    // base case 1: pattern is empty
    if (pattern.isEmpty()) return listOf(0)
    // base case 2: text's length is less than that of pattern's
    if (pattern.length > text.length) return listOf()

    val chars = pattern.toCharArray()
    val result = mutableListOf<Int>()

    // next[i] stores the index of the next best partial match
    val next = IntArray(pattern.length + 1)
    for (i in pattern.indices) {
        var j = next[i + 1]
        while (j > 0 && chars[j] != chars[i]) {
            j = next[j]
        }
        if (j > 0 || chars[j] == chars[i]) {
            next[i + 1] = j + 1
        }
    }

    var i = 0
    var j = 0
    while (i < text.length) {
        if (j < pattern.length && text[i] == pattern[j]) {
            if (++j == pattern.length) {
                result.add(i - j + 1)
            }
        } else if (j > 0) {
            j = next[j]
            i-- // since `i` will be incremented in the next iteration
        }
        i++
    }

    return result
}
