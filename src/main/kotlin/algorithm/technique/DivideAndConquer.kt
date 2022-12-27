package algorithm.technique

// Main idea: break the problem into small subproblems and solve it.

// Binary Search
// Complexity time/space: O(logn)/O(1)
fun binarySearch(arr: Array<Int>, target: Int): Int {
    var low = 0
    var high = arr.size - 1

    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            target < arr[mid] -> high = mid - 1
            target > arr[mid] -> low = mid + 1
            else -> return mid
        }
    }
    return -1
}
