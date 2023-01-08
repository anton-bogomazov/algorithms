package problem.array

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LongestAlternatingSubsequenceKtTest : StringSpec({
    "longest alternating subsequence minimum valid input" {
        val array = arrayOf(1)
        val expected = 1
        val result = longestAlternatingSubsequence(array)
        result shouldBe expected
    }

    "longest alternating subsequence no alternating subsequence" {
        val array = arrayOf(1, 2, 3, 4)
        val expected = 2
        val result = longestAlternatingSubsequence(array)
        result shouldBe expected
    }

    "longest alternating subsequence small array" {
        val array = arrayOf(1, 3, 2, 4)
        val expected = 4
        val result = longestAlternatingSubsequence(array)
        result shouldBe expected
    }

    "longest alternating subsequence big array" {
        val array = arrayOf(8, 9, 6, 4, 5, 7, 3, 2, 4)
        val expected = 6
        val result = longestAlternatingSubsequence(array)
        result shouldBe expected
    }
})
