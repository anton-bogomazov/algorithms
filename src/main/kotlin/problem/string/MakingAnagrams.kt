package problem.string

import kotlin.math.abs

// Find the min number of deletions to make 2 strings anagrams.
// Complexity time/space: O(n)/O(n)
private const val alphabetPower = 26

fun makingAnagrams(a: String, b: String): Int {
    val aFrequencies = CharArray(alphabetPower)
    val bFrequencies = CharArray(alphabetPower)

    for (c in a) aFrequencies[c - 'a']++
    for (c in b) bFrequencies[c - 'a']++

    var deletions = 0
    for (i in 0 until 26) {
        deletions += abs(aFrequencies[i] - bFrequencies[i])
    }

    return deletions
}
