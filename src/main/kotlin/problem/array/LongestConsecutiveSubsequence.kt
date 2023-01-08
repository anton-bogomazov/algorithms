package problem.array

// Find the length of the longest subsequence formed by the consecutive integers.
// The subsequence should contain all distinct values,
// and the character set should be consecutive, irrespective of its order.
// Complexity time/space: O(n)/O(n)
fun longestConsecutiveSubsequence(array: Array<Int>): Int {
    val set = array.toSet()

    var maxLength = 0

    for (e in array) {
        // check if the current element `e` is a candidate for starting a sequence,
        // i.e., the previous element `e-1` doesn't exist in the set
        if (!set.contains(e - 1)) {
            // `len` stores the length of subsequence, starting with the
            // current element
            var len = 1

            // check for presence of elements `e+1`, `e+2`, `e+3`, … ,`e+len`
            // in the set
            while (set.contains(e + len)) {
                len++
            }

            // update result with the length of current consecutive subsequence
            maxLength = maxLength.coerceAtLeast(len)
        }
    }

    return maxLength
}
