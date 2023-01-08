package problem.string

import util.Matrix

// Find the shortest supersequence Z of given sequences X and Y such that both X and Y are subsequences of Z.
// Complexity time/space: O(m*n)/O(m*n)
fun shortestCommonSupersequence(x: String, y: String): Int {
    val m = x.length
    val n = y.length

    // lookup table stores solution to already computed subproblems
    val table = Matrix.intMatrix(m + 1, n + 1)

    // initialize lookup table
    for (i in 0..m) table[i][0] = i
    for (j in 0..n) table[0][j] = j

    // fill the lookup table in a bottom-up manner
    for (i in 1..m) {
        for (j in 1..n) {
            // if the current character of `X` and `Y` matches
            if (x[i - 1] == y[j - 1]) {
                table[i][j] = table[i - 1][j - 1] + 1
            } else {
                table[i][j] = Integer.min(table[i - 1][j] + 1, table[i][j - 1] + 1)
            }
        }
    }

    return table[m][n]
}
