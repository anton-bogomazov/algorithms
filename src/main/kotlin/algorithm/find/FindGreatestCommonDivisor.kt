package algorithm.find

// Euclid’s algorithm
// Finding the greatest common divisor of two numbers.
// Worst case complexity time/space: O(log(n))/O(1)
fun findGreatestCommonDivisor(a: Int, b: Int): Int {
    var x = a
    var y = b

    while (y != 0) {
        val temp = y
        y = x % y
        x = temp
    }

    return x
}
