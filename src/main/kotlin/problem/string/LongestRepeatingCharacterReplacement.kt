package problem.string

// Find the length of the longest substring containing the same letter.
// You can choose any character of the string and change it k times.
// Complexity time/space: O(n)/O(m)
private const val alphabetPower = 26

fun longestRepeatingCharacterReplacement(str: String, k: Int): Int {
    val frequencyMap = IntArray(alphabetPower)

    var start = 0
    var maxFrequency = 0
    var longestSubstringLength = 0

    for (end in str.indices) {

        // if 'A' is 0, then what is the relative order
        // or offset of the current character entering the window
        // 0 is 'A', 1 is 'B' and so on
        val currentChar = str[end].code - 'A'.code
        frequencyMap[currentChar] += 1

        // the maximum frequency we have seen in any window yet
        maxFrequency = maxFrequency.coerceAtLeast(frequencyMap[currentChar])

        // move the start pointer towards right if the current
        // window is invalid
        val isValid = end + 1 - start - maxFrequency <= k
        if (!isValid) {
            // offset of the character moving out of the window
            val outgoingChar = str[start].code - 'A'.code

            // decrease its frequency
            frequencyMap[outgoingChar] -= 1

            // move the start pointer forward
            start += 1
        }

        // the window is valid at this point, note down the length
        // size of the window never decreases
        longestSubstringLength = end + 1 - start
    }

    return longestSubstringLength
}
