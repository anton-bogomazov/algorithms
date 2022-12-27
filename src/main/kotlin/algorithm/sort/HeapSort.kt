package algorithm.sort

// Main idea: build heap and extract values to array.
// Worst case complexity time/space: O(n*log(n))/O(1)
fun heapSort(array: Array<Int>) {
    // build heap: call heapify starting from the last internal
    // node all the way up to the root node
    for (i in array.size / 2 - 1 downTo 0) {
        heapify(array, array.size, i)
    }

    // extract elements from the heap one by one
    for (i in array.indices.reversed()) {
        // move the current root to the end
        val temp = array[0]
        array[0] = array[i]
        array[i] = temp

        // call heapify on the reduced heap
        heapify(array, i, 0)
    }
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
