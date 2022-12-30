package problem.longest

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LongestAlternatingSubarrayKtTest : StringSpec({

    "longest alternating subarray minimum valid input" {
        val array = arrayOf(1)

        longestAlternatingSubarray(array) shouldBe arrayOf(1)
    }

    "longest alternating subarray no alternating subsequence" {
        val array = arrayOf(1, 2, 3, 4)

        longestAlternatingSubarray(array) shouldBe arrayOf(1)
    }

    "longest alternating subarray small array" {
        val array = arrayOf(1, -3, 2, 4)

        longestAlternatingSubarray(array) shouldBe arrayOf(1, -3, 2)
    }

    "longest alternating subarray big array" {
        val array = arrayOf(8, -9, 6, -4, -5, 7, -3, 2, -4, 4)

        longestAlternatingSubarray(array) shouldBe arrayOf(-5, 7, -3, 2, -4, 4)
    }

})
