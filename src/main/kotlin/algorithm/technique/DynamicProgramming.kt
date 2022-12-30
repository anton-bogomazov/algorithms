package algorithm.technique

// Main idea: avoid recalculating the solution to a subproblem by storing the results,
// and then using these stored values to obtain the solution to the original problem.
// This technique is called "memoization."

// Find n-th Fibonacci number.
// Complexity time/space: O(n)/O(n)
fun fibonacci(n: Int): Int {
    val f = IntArray(n + 2)

    f[0] = 0
    f[1] = 1
    for (i in 2..n) {
        // use previously stored numbers to get a new one
        f[i] = f[i - 1] + f[i - 2]
    }

    return f[n]
}
