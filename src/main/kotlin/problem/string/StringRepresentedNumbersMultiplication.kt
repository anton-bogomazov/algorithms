package problem.string

// Given two non-negative integers num1 and num2 represented as strings,
// return the product of num1 and num2, also represented as a string.
// Complexity time/space: O(M⋅N)/O(M+N)
fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") return "0"

    val firstNumber = StringBuilder(num1)
    val secondNumber = StringBuilder(num2)

    firstNumber.reverse()
    secondNumber.reverse()

    val resultLength = firstNumber.length + secondNumber.length
    val result = StringBuilder()
    for (i in 0 until resultLength) result.append(0)

    for (i in secondNumber.indices) {
        for (j in firstNumber.indices) {
            val firstDigit = firstNumber[j].code - '0'.code
            val secondDigit = secondNumber[i].code - '0'.code

            val resultCharIndex = j + i
            val borrow = result[resultCharIndex].code - '0'.code
            val multiplication = secondDigit * firstDigit + borrow

            result.setCharAt(resultCharIndex, (multiplication % 10 + '0'.code).toChar())

            val toNextIteration = result[resultCharIndex + 1].code - '0'.code + multiplication / 10
            result.setCharAt(resultCharIndex + 1, (toNextIteration + '0'.code).toChar())
        }
    }

    if (result[result.length - 1] == '0') {
        result.deleteCharAt(result.length - 1)
    }

    return result.reversed().toString()
}
