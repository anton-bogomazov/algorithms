package algorithm.find

// Boyer–Moore Majority Vote Algorithm
// Given an integer array containing duplicates, return the majority element if present.
// A majority element appears more than n/2 times, where n is the array size.
// Worst case complexity time/space: O(n)/O(1)
fun findMajorityElement(array: Array<Int>): Int? {
    var majorityElement: Int? = null
    var count = 0

    for (num in array) {
        if (count == 0) {
            majorityElement = num
            count = 1
        } else if (num == majorityElement) {
            count++
        } else {
            count--
        }
    }

    if (array.count { it == majorityElement } <= array.size / 2) return null

    return majorityElement
}
