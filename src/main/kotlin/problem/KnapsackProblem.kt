package problem

import util.Matrix.Companion.intMatrix
import kotlin.math.max

// todo document all methods
/**
 * Collect items from array so that the total weight is less than or equal
 * to a given limit and the total value is as large as possible
 *
 * Complexity time/space: O(2^n)/stack size
 */
fun collectKnapsack(items: List<Pair<Int, Int>>, knapsackCapacity: Int): Int =
    solveRecursively(items, items.lastIndex, knapsackCapacity)

// Complexity time/space: O(n^2)/O(n^2)
fun collectKnapsackWithHashmap(items: List<Pair<Int, Int>>, knapsackCapacity: Int): Int =
    solveRecursively(items, items.lastIndex, knapsackCapacity, hashMapOf())

private fun solveRecursively(
    items: List<Pair<Int, Int>>,
    lastItemIndex: Int,
    knapsackCapacity: Int,
    map: HashMap<String, Int>? = null
): Int {
    if (knapsackCapacity < 0) return Int.MIN_VALUE
    if (lastItemIndex < 0 || knapsackCapacity == 0) return 0

    val value = items[lastItemIndex].first
    val weight = items[lastItemIndex].second

    val key = "$value|$weight"
    if (map?.containsKey(key) == true) return map[key]!!

    val valueWithItem = value + solveRecursively(items, lastItemIndex - 1, knapsackCapacity - weight, map)
    val valueWithoutItem = solveRecursively(items, lastItemIndex - 1, weight, map)

    val result = max(valueWithItem, valueWithoutItem)

    map?.put(key, result)

    return result
}

// Complexity time/space: O(n^2)/O(n^2)
fun collectKnapsackDP(items: List<Pair<Int, Int>>, knapsackCapacity: Int): Int {
    val matrix = intMatrix(items.size + 1, knapsackCapacity + 1)

    for (i in 1..items.size) {
        for (j in 1..knapsackCapacity) {
            val value = items[i - 1].first
            val weight = items[i - 1].second

            if (weight > j) {
                matrix[i][j] = matrix[i - 1][j]
            } else {
                matrix[i][j] = max(matrix[i - 1][j], matrix[i - 1][j - weight] + value)
            }
        }
    }

    return matrix[items.size][knapsackCapacity]
}
