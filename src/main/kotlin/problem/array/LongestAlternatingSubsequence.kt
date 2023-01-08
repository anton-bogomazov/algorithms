package problem.array

import util.Matrix

// Find a subsequence of a given sequence in which the elements are in alternating order
// and in which the sequence is as long as possible.
// In order words, we need to find the length of the longest subsequence with alternate low and high elements.
// Complexity time/space: O(n2)/O(n)
fun longestAlternatingSubsequence(array: Array<Int>): Int {
    if (array.size <= 1) return array.size

    val table = Matrix.intMatrix(array.size, 2)

    /*
         `T[i][0]` stores the longest alternating subsequence till `A[0…i]`
         where `A[i]` is greater than `A[i-1]`

         `T[i][1]` stores the longest alternating subsequence till `A[0…i]`
         where `A[i]` is smaller than `A[i-1]`
     */

    var result = 1

    // base case: the first element will always be part of LAS
    table[0][1] = 1
    table[0][0] = table[0][1]

    // fill the lookup table in a bottom-up manner
    for (i in 1..array.lastIndex) {
        // do for each element `A[j]` before `A[i]`
        for (j in 0 until i) {
            // If `A[i]` is greater than `A[j]`, update `T[i][0]`
            if (array[i] > array[j]) {
                table[i][0] = table[i][0].coerceAtLeast(table[j][1] + 1)
            }

            // If `A[i]` is smaller than `A[j]`, update `T[i][1]`
            if (array[i] < array[j]) {
                table[i][1] = table[i][1].coerceAtLeast(table[j][0] + 1)
            }
        }

        // update result by taking a maximum of both values
        val max = table[i][0].coerceAtLeast(table[i][1])
        if (result < max) {
            result = max
        }
    }

    return result
}
