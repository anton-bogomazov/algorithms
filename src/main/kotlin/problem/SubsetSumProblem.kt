package problem

import util.Matrix.Companion.matrix

/**
 * Given a set of positive integers and an integer k,
 * check if there is any non-empty subset that sums to k
 *
 * Complexity time/space: O(2^n)/stack size
 */
fun findSubset(array: IntArray, target: Int): Boolean =
    solveRecursively(array, array.lastIndex, target)

fun findSubsetWithHashmap(array: IntArray, target: Int): Boolean =
    solveRecursively(array, array.lastIndex, target, hashMapOf())

private fun solveRecursively(
    array: IntArray,
    lastIndex: Int,
    target: Int,
    map: HashMap<String, Boolean>? = null
): Boolean {
    if (target == 0) return true
    if (lastIndex < 0 || target < 0) return false

    val key = "$lastIndex|$target"
    if (map?.containsKey(key) == true) return map[key]!!

    val withValue = solveRecursively(array, lastIndex - 1, target - array[lastIndex])
    val withoutValue = solveRecursively(array, lastIndex - 1, target)

    val result = withValue || withoutValue
    map?.put(key, result)

    return result
}

fun findSubsetDP(array: IntArray, target: Int): Boolean {
    val matrix = matrix(array.size + 1, target + 1, false)

    for (i in 0..array.size) {
        matrix[i][0] = true
    }

    for (i in 1..array.size) {
        for (j in 1..target) {
            if (array[i - 1] > j) {
                matrix[i][j] = matrix[i - 1][j]
            } else {
                matrix[i][j] = matrix[i - 1][j] || matrix[i - 1][j - array[i - 1]]
            }
        }
    }

    return matrix[array.size][target]
}
