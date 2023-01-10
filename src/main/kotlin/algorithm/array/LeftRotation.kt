package algorithm.array

// A Juggling Algorithm for array rotation
// Complexity time/space: O(n)/O(1)
fun leftRotate(array: IntArray, numberOfRotations: Int) {
    // handle values greater than array.size
    if (array.size < 2) return
    val numberOfRotations = numberOfRotations % array.size
    if (numberOfRotations == 0) return

    val rotateIndex = gcd(numberOfRotations, array.size)

    for (i in 0 until rotateIndex) {
        val temp = array[i]
        var j = i

        while (true) {
            var k = j + numberOfRotations
            k = if (k >= array.size) k - array.size else k
            if (k == i) break

            array[j] = array[k]
            j = k
        }

        array[j] = temp
    }
}

private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
