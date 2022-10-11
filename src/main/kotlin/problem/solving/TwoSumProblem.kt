package problem.solving

import kotlin.math.abs

//  Given an unsorted unique integers array, find a pair with the given sum in it.

// Complexity time/space: O(n^2)/O(1)
fun findPairBruteforce(nums: IntArray, target: Int): Pair<Int, Int> {
    for (number in nums) {
        for (potentialPair in nums) {
            if (number + potentialPair == target) return number to potentialPair
        }
    }

    error("Pair not found")
}

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

    error("Pair not found")
}

// Complexity time/space: O(n)/O(n)
fun findPairWithSet(nums: IntArray, target: Int): Pair<Int, Int> {
    val set = mutableSetOf<Int>()

    for (num in nums) {
        val diff = abs(target - num)
        if (set.contains(diff)) return sortedPairOf(num, diff)

        set.add(num)
    }

    error("Pair not found")
}

private fun sortedPairOf(first: Int, second: Int): Pair<Int, Int> =
    if (first > second) second to first else first to second
