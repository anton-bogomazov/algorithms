package algorithm.sort

// Main idea: divide array into smaller pieces, sort it and merge.
// Worst case complexity time/space: O(n*log(n))/O(n)
fun mergeSort(arr: Array<Int>) {
    mergeSort(arr, arr.clone(), 0, arr.lastIndex)
}

private fun mergeSort(arr: Array<Int>, aux: Array<Int>, low: Int, high: Int) {
    // base case (size <= 1)
    if (high <= low) return

    // find midpoint
    val mid = low + (high - low shr 1)

    // recursively split runs into two halves until run size > 1
    mergeSort(arr, aux, low, mid)
    mergeSort(arr, aux, mid + 1, high)

    // then merge them and return up the call chain
    merge(arr, aux, low, mid, high)
}

private fun merge(arr: Array<Int>, aux: Array<Int>, low: Int, mid: Int, high: Int) {
    var k = low
    var i = low
    var j = mid + 1

    // while there are elements in the left and right runs
    while (i <= mid && j <= high) {
        if (arr[i] <= arr[j]) {
            aux[k++] = arr[i++]
        } else {
            aux[k++] = arr[j++]
        }
    }

    // copy remaining elements
    while (i <= mid) aux[k++] = arr[i++]

    // No need to copy the second half (since the remaining items
    // are already in their correct position in the auxiliary array)
    // copy back to the original array to reflect sorted order
    i = low
    while (i <= high) {
        arr[i] = aux[i]
        i++
    }
}
