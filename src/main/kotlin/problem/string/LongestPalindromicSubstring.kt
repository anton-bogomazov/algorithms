package problem.string

// Find the longest substring of a string that's also a palindrome.
// Complexity time/space: O(n2)/O(1)
fun longestPalindromicSubstring(str: String): Int {
    var maxLength = 1

    // Nested loop to mark start and end index
    for (i in str.indices) {
        for (j in i..str.lastIndex) {
            var isPalindrome = true

            for (k in 0 until (j - i + 1) / 2) {
                if (str[i + k] != str[j - k]) {
                    isPalindrome = false
                }
            }

            if (isPalindrome && j - i + 1 > maxLength) {
                maxLength = j - i + 1
            }
        }
    }

    return maxLength
}
