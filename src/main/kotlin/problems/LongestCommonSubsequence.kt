package problems

import utils.Matrix.Companion.intMatrix
import kotlin.math.max

//  Find the longest sequence which can be obtained
//  from the first original sequence by deleting some items
//  and from the second original sequence by deleting other items.

// Complexity time/space: O(2^n)/stack size
fun findLcsRecursion(seqX: String, seqY: String): Int =
    solveRecursively(
        seqX = seqX, seqY = seqY,
        seqXLastIndex = seqX.lastIndex,
        seqYLastIndex = seqY.lastIndex)

// Complexity time/space: O(n^2)/O(n^2)
fun findLcsRecursionWithHashMap(seqX: String, seqY: String): Int =
    solveRecursively(
        seqX = seqX, seqY = seqY,
        seqXLastIndex = seqX.lastIndex,
        seqYLastIndex = seqY.lastIndex,
        map = hashMapOf())

private fun solveRecursively(
    seqX: String,
    seqY: String,
    seqXLastIndex: Int,
    seqYLastIndex: Int,
    map: HashMap<String, Int>? = null
): Int {
    if (seqXLastIndex < 0 || seqYLastIndex < 0) return 0

    val key = "$seqXLastIndex|$seqYLastIndex"
    if (map?.containsKey(key) == true) return map[key]!!

    val result = if (seqX[seqXLastIndex] == seqY[seqYLastIndex]) {
        1 + solveRecursively(seqX, seqY, seqXLastIndex - 1, seqYLastIndex - 1)
    } else {
        max(
            solveRecursively(seqX, seqY, seqXLastIndex, seqYLastIndex - 1),
            solveRecursively(seqX, seqY, seqXLastIndex - 1, seqYLastIndex)
        )
    }

    map?.put(key, result)

    return result
}

// Complexity time/space: O(n^2)/O(n^2)
fun findLcsDP(seqX: String, seqY: String): Int {
    if (seqX.isEmpty() || seqY.isEmpty()) return 0

    val matrix = intMatrix(seqX.length + 1, seqY.length + 1)

    for (i in 1..seqX.length) {
        for (j in 1..seqY.length) {
            if (seqX[i - 1] == seqY[j - 1]) {
                matrix[i][j] = matrix[i - 1][j - 1] + 1
            } else {
                matrix[i][j] = max(matrix[i][j - 1], matrix[i - 1][j])
            }
        }
    }

    return matrix[seqX.length][seqY.length]
}
