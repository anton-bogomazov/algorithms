package algorithm.technique

// This technique involves manipulating the individual bits in a number.
fun sum(x: Int, y: Int): Int {
    var x = x
    var y = y

    while (y != 0) {
        // carry now contains common set bits of x and y
        val carry = x and y
        // Sum of bits of x and y where at least one of the bits is not set
        x = x xor y
        // Carry is shifted by one so that adding it to x gives the required sum
        y = carry shl 1
    }

    return x
}
