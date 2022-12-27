package algorithm.technique

import exception.noSolutionError

// Traverse the input data using two pointers in opposite directions.
// It is often used to find pairs of elements that satisfy a certain condition.
// Complexity time/space: O(nlogn)/O(1)
fun findPairTwoPointers(nums: IntArray, target: Int): Pair<Int, Int> {
    val sortedNums = nums.sorted()
    var leftPointer = 0
    var rightPointer = sortedNums.lastIndex

    while (leftPointer < rightPointer) {
        val currentSum = sortedNums[leftPointer] + sortedNums[rightPointer]

        when {
            currentSum == target -> return sortedNums[leftPointer] to sortedNums[rightPointer]
            currentSum > target -> --rightPointer
            currentSum < target -> ++leftPointer
        }
    }

    noSolutionError()
}
