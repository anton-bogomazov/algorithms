package algorithm.find

import kotlin.math.pow

// Find a power set for an array.
// Power set is set of all subsets, empty set and the original set itself.
// Worst case complexity time/space: O(n*2^n)/O(n)
fun findPowerSet(array: Array<Int>): Set<Set<Int>> {
    val powerSetSize = 2.0.pow(array.size).toLong()
    val powerSet = mutableSetOf<Set<Int>>()

    for (i in 0 until powerSetSize) {
        val subset = mutableSetOf<Int>()
        for (j in array.indices) {
            if (i and ((1 shl j).toLong()) > 0) subset.add(array[j])
        }
        powerSet.add(subset)
    }

    return powerSet
}
