package algorithm.sort

// Main idea: minimize number of writes by calculating correct position for each item before swapping.
// Worst case complexity time/space: O(n2)/O(1)
fun cycleSort(array: Array<Int>) {
    for (cycleStartIndex in array.indices) {
        var startItem = array[cycleStartIndex]

        // find the position where item should go:
        // count elements that less than startItem
        var correctPosition = cycleStartIndex
        for (i in cycleStartIndex + 1 until array.size) {
            if (array[i] < startItem) correctPosition++
        }

        // if item is already in the correct position, this is not a cycle
        if (correctPosition == cycleStartIndex) continue
        // ignore all duplicate elements
        while (startItem == array[correctPosition]) correctPosition += 1

        // swap
        startItem = array[correctPosition].also { array[correctPosition] = startItem }

        // rotate the rest of the cycle
        while (correctPosition != cycleStartIndex) {
            correctPosition = cycleStartIndex
            for (i in cycleStartIndex + 1 until array.size) {
                if (array[i] < startItem) correctPosition += 1
            }

            // ignore all duplicate elements
            while (startItem == array[correctPosition]) correctPosition += 1

            // swap
            startItem = array[correctPosition].also { array[correctPosition] = startItem }
        }
    }
}
