package algorithm.merge

// Given two binary max heaps as arrays. Merge it.
// Worst case complexity time/space: O(n+k)/O(n+k)
fun mergeHeaps(arr1: Array<Int>, arr2: Array<Int>): Array<Int> {
    val mergedArray = arr1 + arr2
    for (i in mergedArray.size / 2 - 1 downTo 0) {
        heapify(mergedArray, mergedArray.size, i)
    }
    return mergedArray
}

// build max heap
private fun heapify(arr: Array<Int>, size: Int, root: Int) {
    val left = 2 * root + 1
    val right = 2 * root + 2

    var largest = root

    // compare root with left/right and find largest
    if (left < size && arr[left] > arr[root]) largest = left
    if (right < size && arr[right] > arr[root]) largest = right

    // if largest is not root
    if (largest != root) {
        val temp = arr[root]
        arr[root] = arr[largest]
        arr[largest] = temp

        // swap with a child having greater value and
        // call heapify-down on the child
        heapify(arr, size, largest)
    }
}
