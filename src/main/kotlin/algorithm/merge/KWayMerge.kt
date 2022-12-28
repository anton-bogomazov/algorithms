package algorithm.merge

import java.util.*

// Merge given k sorted arrays to one sorted array.
// Worst case complexity time/space: O(n*log(k))/O(k)
fun kWayMerge(arrays: Array<Array<Int>>): Array<Int> {
    val result = mutableListOf<Int>()

    val heap = PriorityQueue<Cursor>(compareBy { it.value })

    // add the first element of each array to the heap
    arrays.forEachIndexed { index, array ->
        if (array.isNotEmpty()) {
            heap.add(Cursor(array[0], 0, index))
        }
    }

    while (heap.isNotEmpty()) {
        // get the minimum element from the heap
        val (value, valueIndex, arrayIndex) = heap.poll()

        // add the minimum element to the result
        result.add(value)

        // add the next element of the array to the heap
        if (valueIndex + 1 in arrays[arrayIndex].indices) {
            heap.add(Cursor(arrays[arrayIndex][valueIndex + 1], valueIndex + 1, arrayIndex))
        }
    }

    return result.toTypedArray()
}

data class Cursor(val value: Int, val valueIndex: Int, val arrayIndex: Int)
