package algorithm.sort

// Main idea: choose pivot and set lesser elements on the left and greater on the right.
// Average case complexity time/space: O(n*log(n))/O(n). Worst case is O(n2).
fun quickSort(array: Array<Int>) {
    quickSort(array, 0, array.lastIndex)
}

private fun quickSort(array: Array<Int>, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = partition(array, low, high)
        quickSort(array, low, pivotIndex - 1)
        quickSort(array, pivotIndex + 1, high)
    }
}

private fun partition(arr: Array<Int>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low

    for (j in low until high) {
        if (arr[j] < pivot) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            i++
        }
    }

    val temp = arr[i]
    arr[i] = pivot
    arr[high] = temp

    return i
}
