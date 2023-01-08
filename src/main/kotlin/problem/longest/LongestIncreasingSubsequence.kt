package problem.longest

// Find a subsequence of a given sequence in which the subsequence’s elements are in sorted order,
// lowest to highest, and in which the subsequence is as long as possible.
// Complexity time/space: O(n2)/O(n*log(n))
fun longestIncreasingSubsequence(array: IntArray): Int {
    if (array.isEmpty()) return 0

    // Does not represent an actual sequence.
    val set = sortedSetOf<Int>()
    for (num in array) {
        if (set.contains(num)) continue

        // replace or add to the end of set
        set.add(num)
        // if there is a greater than num element, delete it from set
        set.higher(num)?.let { set.remove(it) }
    }

    return set.size
}
