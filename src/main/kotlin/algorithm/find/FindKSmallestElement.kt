package algorithm.find

import algorithm.util.swap
import kotlin.random.Random

// Find the k'th the smallest element in an unordered list.
// Average case complexity time/space: O(n*log(n))/O(n). Worst case is O(n2).
fun quickSelect(array: Array<Int>, k: Int): Int {
    array.shuffle()
    var left = 0
    var right = array.lastIndex

    // repeat until left and right pointers meet
    while (left < right) {
        val pivotIndex = partition(array, left, right)

        // if pivot is the kth smallest element, return it
        if (pivotIndex == k - 1) {
            return array[pivotIndex]
        } else if (pivotIndex < k - 1) {
            // search in the right half of the array
            left = pivotIndex + 1
        } else {
            // search in the left half of the array
            right = pivotIndex - 1
        }
    }

    return array[left]
}

// Partition using Lomuto partition scheme
fun partition(nums: Array<Int>, left: Int, right: Int): Int {
    // pick `pIndex` as a pivot from the array
    var pIndex = Random.nextInt(left, right)
    val pivot = nums[pIndex]

    // Move pivot to end
    nums.swap(pIndex, right)

    // elements less than the pivot will be pushed to the left of `pIndex`;
    // equal elements can go either way
    pIndex = left

    // each time we find an element less than or equal to the pivot, `pIndex`
    // is incremented, and that element would be placed before the pivot.
    for (i in left until right) {
        if (nums[i] <= pivot) {
            nums.swap(i, pIndex)
            pIndex++
        }
    }

    // move pivot to its final place
    nums.swap(pIndex, right)

    return pIndex
}
