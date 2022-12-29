package algorithm.find

// Given an array of N numbers and a positive integer K.
// Find K numbers with the most occurrences, i.e., the top K numbers having the maximum frequency.
// If two numbers have the same frequency then the number with a larger value should be given preference.
// Worst case complexity time/space: O(n*log(n))/O(n)
fun findKFrequentNumbers(array: Array<Int>, k: Int): List<Int> {
    val map = mutableMapOf<Int, Int>()

    // Put count of all the distinct elements in Map with element as the key & count as the value.
    for (i in array.indices) {
        // Get the count for the element if already present or get the default value which is 0.
        map[array[i]] = map.getOrDefault(array[i], 0) + 1
    }

    return map.entries.sortedWith(compareBy({ -it.value }, { -it.key })).take(k).map { it.key }
}
